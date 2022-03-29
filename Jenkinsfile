pipeline {
    agent any
    stages {
        stage ('Run test') {
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