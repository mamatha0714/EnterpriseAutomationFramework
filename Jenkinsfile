pipeline {

    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        ENV = 'qa'
    }

    stages {

        stage('Checkout Code') {

            steps {
                checkout scm
            }
        }

        stage('Verify Environment') {

            steps {

                sh 'java -version'
                sh 'mvn -version'
                sh 'docker --version'
            }
        }

        stage('Start Selenium Grid') {

            steps {

                sh '''
                    docker compose up -d
                '''
            }
        }

        stage('Wait For Grid') {

            steps {

                sh '''
                    sleep 15
                '''
            }
        }

        stage('Run Tests') {

            steps {

                sh """
                    mvn clean test \
                    -Denv=${ENV}
                """
            }
        }

        stage('Generate Allure Report') {

            steps {

                allure(
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'allure-results']]
                )
            }
        }
    }

    post {

        always {

            archiveArtifacts(
                artifacts: 'screenshots/**/*.png',
                allowEmptyArchive: true
            )

            archiveArtifacts(
                artifacts: 'allure-results/**/*',
                allowEmptyArchive: true
            )

            sh '''
                docker compose down
            '''
        }

        success {

            echo 'Execution Completed Successfully'
        }

        failure {

            echo 'Execution Failed'
        }
    }
}
