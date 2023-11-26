pipeline {
    agent any

    environment {
        DOCKER_REGISTRY = 'hub.docker.com/danificad0/praticandoapi' // Substitua pelo seu registro Docker
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Docker Login') {
            steps {
                script {
                    // Obtém as credenciais do Jenkins
                    def dockerCredentials = credentials(DOCKER_CREDENTIAL_ID)

                    // Realiza o login no registro Docker
                    docker.withRegistry(DOCKER_REGISTRY, 'docker-credentials-id') {
                        // Aqui você pode fazer o docker login
                        // A autenticação já foi realizada pela 'docker.withRegistry'
                    }
                }
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:prepare-agent test jacoco:report'
            }
        }

        stage('Docker Build') {
            steps {
                // Construção da imagem Docker
                bat 'docker build -t ${DOCKER_REGISTRY}/seu-usuario/seu-projeto .'
            }
        }

        stage('Docker Push') {
            steps {
                // Envio da imagem Docker para o registro
                bat 'docker push ${DOCKER_REGISTRY}/seu-usuario/seu-projeto'
            }
        }
    }
}
