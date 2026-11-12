pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // GitHub Repository URL-ah ungaloda link-ku etha maathiri check pannikonga
                git branch: 'main', url: 'https://github.com/priya-dharshini08/sensor-anomaly-detector.git'
            }
        }

        stage('Build and Test Datasets') {
            steps {
                // Maven clean & test command run aagum
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Maven surefire test reports-ah Jenkins-ku record pannum
            junit 'target/surefire-reports/*.xml'
        }
    }
}