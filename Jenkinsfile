pipeline {
    agent any
    stages {
        stage ('Run test') {
            agent {
                docker {
                    image 'openjdk:8u322-jdk-slim'
                    reuseNode true

                }
            }
            steps {
                   sh "./gradlew -Denv=qa sub:on-test"
            }
        }
        stage ('Generate report') {
            steps {
               allure includeProperties: false, jdk: '', results: [[path: "sub/reports/qa/allure-results"]]
            }
        }
    }

}