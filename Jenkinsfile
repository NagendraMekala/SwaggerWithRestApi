pipeline {
    agent any 
    stages {
        stage('---clean it---') { 
            steps {
                sh "mvn clean"
            }
        }
        stage('---test---') { 
            steps {
                sh "mvn test"
            }
        }
        stage('---deploy---') { 
            steps {
                sh "mvn package"
            }
        }
    }
}