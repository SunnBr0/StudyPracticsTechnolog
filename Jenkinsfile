pipeline {
    agent any
    environment {
        M2_HOME = "C:\\Program Files\\apache-maven-3.9.9"
        PATH = "${M2_HOME}/bin;${PATH}"
    }

    stages {
        // 2 Компиляция кода программы и тестов (mvn)
        stage("Build") {
            steps {
                bat 'mvn clean package'
            }
        }
        // 3 Запуск тестов (только для веток feature/XXX) (mvn)
        stage("Tests") {
            when {
                expression { return env.BRANCH_NAME?.startsWith('feature/') }
            }
            steps {
                bat 'mvn test'
            }
        }
        //4 Запуск статического анализатора (любой из checkstyle, pmd, findbug и др) (только для ветки dev) (mvn или другой вариант)
        stage("Checkstyle") {
            when {
                branch 'develop'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }
        // 5 Запуск измерения тестового покрытия (jacoco + mvn или другой)
        stage("Report") {
            when {
                expression { return env.BRANCH_NAME?.startsWith('feature/') }
            }
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        // 6 Инсталяция артефактов в локальный репозиторий только при успехе (mvn)
        stage("Install") {
            steps {
                bat 'mvn install'
            }
        }
        // 8 Публикация (копирование) артефакта в заранее заданную папку (copy)
        stage("Publish") {
            steps {
                bat '''
                    mkdir deploy || echo
                    copy "app\\target\\*.jar" deploy
                '''
                archiveArtifacts artifacts: 'deploy/*.jar', onlyIfSuccessful: true
            }
        }
        
    }
}