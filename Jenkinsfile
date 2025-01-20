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
        
        stage('Build and Test') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew clean build test
                '''
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }
        
        stage('Code Coverage') {
            steps {
                sh './gradlew jacocoTestReport'
            }
            post {
                success {
                    jacoco(
                        execPattern: 'build/jacoco/test.exec',
                        classPattern: 'build/classes/java/main',
                        sourcePattern: 'src/main/java',
                        exclusionPattern: 'src/test/*'
                    )
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('localsonarserver') {
                        sh '''
                            ./gradlew sonarqube \
                                -Dsonar.projectKey=Java-Calculator-Task \
                                -Dsonar.java.source=17 \
                                -Dsonar.java.target=17 \
                                -Dsonar.sources=src/main/java \
                                -Dsonar.tests=src/test/java \
                                -Dsonar.java.binaries=build/classes/java/main \
                                -Dsonar.coverage.jacoco.xmlReportPaths=build/reports/jacoco/test/jacocoTestReport.xml \
                                -Dsonar.coverage.exclusions=**/test/** \
                                -Dsonar.token=$SONAR_TOKEN
                        '''
                    }
                }
            }
        }
        
        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
        stage('Upload Build Artifacts') {
            steps {
                archiveArtifacts artifacts: '''
                    build/libs/*.jar,
                    build/reports/jacoco/test/html/**,
                    build/reports/tests/test/**
                ''', allowEmptyArchive: true
            }
        }
        
        stage('Run Calculator Test') {
            steps {
                sh '''
                    ./gradlew calculatorTask \
                        -Pnum1=10 \
                        -Pnum2=5 \
                        -Poperator=+
                '''
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
            echo 'Build and analysis completed successfully!'
        }
        failure {
            echo 'Build or analysis failed!'
        }
        always {
            // Clean up workspace
            cleanWs()
        }
    }
}
