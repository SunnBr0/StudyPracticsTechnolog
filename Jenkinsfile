pipeline {
    agent any
    
    environment {
        M2_HOME = "C:\\Program Files\\apache-maven-3.9.9"
        PATH = "${M2_HOME}/bin;${PATH}"
    }

    stages {
        stage("Build") {
            steps {
                bat 'mvn clean package'
            }
        }
        stage("Tests") {
            when {
                expression { return env.BRANCH_NAME?.startsWith('feature/') }
            }
            steps {
                bat 'mvn test'
            }
        }
        stage("Checkstyle") {
            when {
                branch 'develop'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }
        stage("Report") {
            when {
                expression { return env.BRANCH_NAME?.startsWith('feature/') }
            }
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        stage("Install") {
            steps {
                bat 'mvn install'
            }
        }
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