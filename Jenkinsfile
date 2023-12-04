pipeline {
    agent any
    stages {
        stage("verify tooling") {
            steps {
                bat '''
                    docker version
                    docker info
                    docker-compose version
                    curl --version
                '''
            }
        }
        stage('Start container') {
            steps {
                    bat 'docker-compose -f docker-compose.stage.yml up'
                    bat 'docker-compose -f docker-compose.stage.yml logs pipeline_homol-api_stage-1'
                  }
        }
        stage('Wait for container') {
            steps {
                bat 'timeout /nobreak /t 40 > nul'
            }
        }
        stage('Run tests against the container') {
            steps {
                script {
                    def containerIds = bat(returnStatus: true, script: 'docker-compose -f docker-compose.stage.yml ps -q').trim().split('\n')
                    def desiredContainerId = containerIds[0] 
                    bat "docker exec ${desiredContainerId} curl http://localhost:9090"
                }
            }
        }
    }
    post {
        success {
            script {
                slackSend(color: '#36a64f', message: "Deployment to stage succeeded!", attachments: [
                    [
                        fallback: "Deploy to production",
                        actions: [
                            [
                                type: 'button',
                                text: 'Deploy to production',
                                style: 'primary'
                            ]
                        ]
                    ]
                ])
            }
        }
        failure {
            slackSend color: '#ff0000', message: "Deployment to stage failed!"
        }
    }
}
