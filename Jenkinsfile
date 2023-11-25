pipeline {
    agent any
    
    stages {
        stage('Build and Deploy to Dev') {
            when {
                expression { env.BRANCH_NAME == 'dev' }
            }
            steps {
                script {
                    echo 'Building and deploying to Dev'
                    checkout scm
                    sh './mvnw clean package'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-dev.yml build'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-dev.yml up -d'
                }
            }
        }
        
        stage('Test on Homolog') {
            when {
                expression { env.BRANCH_NAME == 'homol' }
            }
            steps {
                script {
                    echo 'Testing on Homolog'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-homolog.yml build'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-homolog.yml up -d'
                    sh './mvnw test jacoco:report'
                    
                    def coverage = readFile 'target/site/jacoco/jacoco.xml'
                    def coveragePercentage = sh(script: 'echo $coverage | xmllint --xpath "//counter[@type=\'INSTRUCTION\']/@covered" -', returnStdout: true).trim()
                    
                    if (coveragePercentage.toInteger() < 90) {
                        error "A cobertura de teste é inferior a 90%. A branch não será promovida para produção."
                    }
                }
            }
        }

        stage('Promote to Production') {
            when {
                expression { env.BRANCH_NAME == 'main' }
            }
            steps {
                script {
                    echo 'Promoting to Production'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-production.yml build'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-production.yml up -d'
                }
            }
        }
    }
    
    post {
        failure {
            echo "Falha na construção ou nos testes. A branch não será promovida para produção."
        }
    }
}
