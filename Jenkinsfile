pipeline {
  agent any
  stages {
    stage('Start container') {
      steps {
        bat 'timeout /nobreak 30' // Equivalente a 'sleep 30' no Windows
        bat 'docker-compose -f docker-compose.stage.yml up -d --no-color --wait'
        bat 'docker-compose -f docker-compose.stage.yml ps'
      }
    }
    stage('Wait for container') {
      steps {
        bat 'timeout /nobreak 15' // Equivalente a 'sleep 15' no Windows
      }
    }
    stage('Run tests against the container') {
      steps {
        script {
          def containerIds = bat(script: 'docker-compose -f docker-compose.stage.yml ps -q', returnStatus: true).trim().split('\r\n')
          def desiredContainerId = containerIds[0] 
          bat "docker exec ${desiredContainerId} curl http://localhost:9090"
        }
      }
    }
  }
}
