pipeline {
    agent any
    
    environment {
        M2_HOME = "/Program Files/apache-maven-3.9.9"
        PATH = "${M2_HOME}/bin:${PATH}"
    }

    stages {
        stage("Build") {
            steps {
                sh 'mvn clean package'
            }
        }
        stage("Tests") {
            when {
                branch 'feature/*'
            }
            steps {
                sh 'mvn test'
            }
        }
        stage("Checkstyle") {
            when {
                branch 'develop'
            }
            steps {
                sh 'mvn checkstyle:check'
            }
        }
        stage("Report") {
            when {
                branch 'feature/*'
            }
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        stage("Install") {
            steps {
                sh 'mvn install'
            }
        }
        stage("Publish") {
            steps {
                sh 'cp app/target/app-1.0.0-jar-with-dependencies.jar /VSU UNIVERTY/MagistrPMM/2semestr/CousrePracticsTechnolog && echo "Published"'
            } 
        }
    }
}