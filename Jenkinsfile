pipeline {
    agent any

    stages {
        agent {
          docker {
              image 'gradle:6.9.2-jdk8'
              reuseNode true
          }
        }
        stage ('on-test') {
            steps {
                sh "gradle -Denv=${env} sub:on-test"
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: "sub/reports/${env}/allure-results"]]
        }
    }
}