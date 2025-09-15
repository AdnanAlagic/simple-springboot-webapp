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
            dir('app') {
                archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
            }
        }
    }
}