pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // GitHub repository checkout
                git branch: 'main', url: 'https://github.com/priya-dharshini08/sensor-anomaly-detector.git'
            }
        }

        stage('Build and Test Datasets') {
            steps {
                // Run maven clean and test
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Correct Maven Surefire XML reports path-a specify panrom
            junit 'target/surefire-reports/*.xml'
        }
    }
}