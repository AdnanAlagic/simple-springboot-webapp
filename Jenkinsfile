pipeline {
    agent any

    tools {
        maven 'Maven-3.9.6'
    }

    environment {
        BRANCH_NAME = "${env.BRANCH_NAME}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Building branch: ${BRANCH_NAME}"
                checkout scm
            }
        }

        stage('Test') {
            steps {
                sh '''
                    echo "Running tests on branch: ${BRANCH_NAME}"
                    mvn clean test
                '''
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
            publishTestResults testResultsPattern: 'target/surefire-reports/*.xml'
        }
        success {
            echo "Tests passed on branch: ${BRANCH_NAME}"
        }
        failure {
            echo "Tests failed on branch: ${BRANCH_NAME}"
        }
    }
}