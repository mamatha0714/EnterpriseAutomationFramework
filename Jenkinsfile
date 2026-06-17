pipeline {

    agent any

    tools {

        maven 'Maven3'
    }

    stages {

        stage('Checkout') {

            steps {

                git branch: 'main',
                    url: 'https://github.com/username/repo.git'
            }
        }

        stage('Start Grid') {

            steps {

                sh 'docker compose up -d'
            }
        }

        stage('Run Tests') {

            steps {

                sh 'mvn clean test'
            }
        }

        stage('Generate Allure') {

            steps {

                allure(
                    includeProperties: false,
                    results: [[path: 'allure-results']]
                )
            }
        }

        stage('Stop Grid') {

            steps {

                sh 'docker compose down'
            }
        }
    }
}