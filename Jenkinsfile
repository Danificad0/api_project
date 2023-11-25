pipeline {
    agent any
    
    stages {
        stage('Build and Deploy to Dev') {
            when {
                branch 'dev'
            }
            steps {
                script {
                    // Clona o repositório ou realiza outras ações necessárias
                    checkout scm
                    
                    // Compila o projeto Spring Boot
                    sh './mvnw clean package'
                    
                    // Atualiza a imagem do Docker para Dev
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-dev.yml build'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-dev.yml up -d'
                }
            }
        }
        
        stage('Test on Homolog') {
            when {
                branch 'homolog'
            }
            steps {
                script {
                    // Atualiza a imagem do Docker para Homolog
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-homolog.yml build'
                    sh 'docker-compose -f docker-compose.yml -f docker-compose-homolog.yml up -d'
                    
                    // Executa os testes e gera relatório JaCoCo
                    sh './mvnw test jacoco:report'
                }
            }
        }

        stage('Promote to Production') {
            when {
                branch 'main'
            }
            steps {
                script {
                    def coverage = readFile 'target/site/jacoco/jacoco.xml'
                    
                    // Analisa o relatório JaCoCo e verifica a cobertura
                    def coveragePercentage = sh(script: 'echo $coverage | xmllint --xpath "//counter[@type=\'INSTRUCTION\']/@covered" -', returnStdout: true).trim()
                    
                    if (coveragePercentage.toInteger() >= 90) {
                        // Atualiza a imagem do Docker para Produção
                        sh 'docker-compose -f docker-compose.yml -f docker-compose-production.yml build'
                        sh 'docker-compose -f docker-compose.yml -f docker-compose-production.yml up -d'
                    } else {
                        error "A cobertura de teste é inferior a 90%. A branch não será promovida para produção."
                    }
                }
            }
        }
    }
    
    post {
        failure {
            // Ação a ser executada em caso de falha
            echo "Falha na construção ou nos testes. A branch não será promovida para produção."
        }
    }
}
