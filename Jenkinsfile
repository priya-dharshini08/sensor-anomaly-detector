pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                echo 'Compiling Java source classes and dependencies...'
                sh 'mvn clean compile'
            }
        }

        stage('Execute Test Datasets') {
            steps {
                echo 'Running JUnit tests against normal and abnormal sensor datasets...'
                sh 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
                echo 'Archiving Surefire XML test reports...'
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Sensor Anomaly Detection pipeline passed all test datasets successfully!'
        }
        failure {
            echo 'FAILURE: Anomalies, threshold errors, or build failures detected.'
        }
    }
}