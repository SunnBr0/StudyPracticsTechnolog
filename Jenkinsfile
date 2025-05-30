pipeline {
    agent any
    environment {
        M2_HOME = "C:\\Program Files\\apache-maven-3.9.9"
        PATH = "${M2_HOME}/bin;${PATH}"
    }

    stages {
        stage('1 Import project from git') {
            steps {
                checkout scm
            }
        }
        // 2 Компиляция кода программы и тестов (mvn)
        stage("2 Compile & Test") {
            steps {
                bat 'mvn  compile test-compile'
            }
        }
        // 3 Запуск тестов (только для веток feature/XXX) (mvn)
        stage("3 Tests feature/X") {
            when {
                expression { return env.BRANCH_NAME?.startsWith('feature/') }
            }
            steps {
                bat 'mvn test'
            }
        }
        //4 Запуск статического анализатора (любой из checkstyle, pmd, findbug и др)
        //  (только для ветки dev) (mvn или другой вариант)
        stage("4 Checkstyle") {
            when {
                branch 'develop'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }
        // 5 Запуск измерения тестового покрытия (jacoco + mvn или другой)
        stage("5 Test coverage") {
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        // 6 Инсталяция артефактов в локальный репозиторий только при успехе (mvn)
        stage("6 Install") {
            steps {
                bat 'mvn install'
            }
        }
        stage('7. Check Coverage') {
            steps {
                bat "mvn clean verify"
            }
        }
        // 8 Публикация (копирование) артефакта в заранее заданную папку (copy)
        stage("8 Publish") {
            steps {
                bat '''
                    mkdir deploy || echo
                    copy "app\\target\\*.jar" deploy
                '''
                archiveArtifacts artifacts: 'deploy/*.jar', onlyIfSuccessful: true
            }
        }
        
    }
    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            
            // Сохраняем отчеты JaCoCo
            archiveArtifacts artifacts: '**/target/site/jacoco/**', allowEmptyArchive: true
     
        }
    }
}