pipeline {
  agent any
  stages {
    stage('Start container') {
      steps {
	sh 'sleep 30'
        sh 'docker compose -f docker-compose.stage.yml up -d --no-color --wait'
        sh 'docker compose -f docker-compose.stage.yml ps'
      }
    }
    stage('Wait for container') {
      steps {
        sh 'sleep 15'
      }
    }
    stage('Run tests against the container') {
      steps {
        script {
          def containerIds = sh(returnStdout: true, script: 'docker compose -f docker-compose.stage.yml ps -q').trim().split('\n')
          def desiredContainerId = containerIds[0] 
          sh "docker exec '${desiredContainerId}' curl http://localhost:9090"
        }
      }
    }
  }
  
}
