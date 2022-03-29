pipeline {
    agent any
    stages {
        stage ('Run test') {
            steps {
               sh "./gradlew -Denv=qa sub:on-test"
            }
        }
    }
     post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: "sub/reports/qa/allure-results"]]
        }
     }
}