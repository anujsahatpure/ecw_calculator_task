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
        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('localsonarserver') {
                        sh '''
                            gradle sonarqube \
                                -Dsonar.projectKey=Java-Calculator-Task \
                                -Dsonar.java.source=17 \
                                -Dsonar.java.target=17 \
                                -Dsonar.sources=src/main/java \
                                -Dsonar.tests=src/test/java \
                                -Dsonar.java.binaries=build/classes/java/main \
                                -Dsonar.coverage.exclusions=**/test/** \
                                -Dsonar.token=$SONAR_TOKEN
                        '''
                    }
                }
            }
        }
        stage('Run Calculator Test') {
            steps {
                sh '''
                    gradle calculatorTask \
                        -Pnum1=10 \
                        -Pnum2=5 \
                        -Poperator=+
                '''
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