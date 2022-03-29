pipeline {
    agent any
    stages {
        stage ('on-test') {
            agent {
                docker {
                    image 'gradle:6.9.2-jdk8'
                    reuseNode true
                }
            }
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