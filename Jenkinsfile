pipeline{
    agent any
    stages {
        stage("One"){
            steps{
                echo "Привет! Это лекция магистров про Jenkins"
            }
        }
        stage("Two"){
            steps{
                input "Будем продолжать выполнение конвейра?"
            }
        }
        stage("Three"){
            when{
                not{
                    branch "develop"
                }
            }
            steps{
                echo "Предварительная подготовка"
            }
        }
        stage("Four"){
            parallel{
                stage("Модульные тесты"){
                    steps{
                        echo "Test running ...."
                    }
                }
                stage("Интеграционные тексты"){
                    steps{
                        echo "Integration test running ...."
                    }
                }
            }
        }
    }
}