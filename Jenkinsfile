pipeline {
    agent any
    environment {
        SONARQUBE = 'localsonarserver'
        SONAR_TOKEN = credentials('SONAR_TOKEN')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: "main", url: 'https://github.com/anujsahatpure/ecw_calculator_task.git'
            }
        }
        stage('Build') {
            steps {
                sh 'gradle clean build'
            }
        }
        stage('SonarQube Scan') {
            steps {
                script {
                    withSonarQubeEnv('localsonarserver') {
                        sh "gradle sonarqube -Dsonar.login=$SONAR_TOKEN"
                    }
                }
            }
        }
        stage('Upload Build Artifacts') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
            }
        }
        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }
    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
