pipeline {
    agent any
    stages {
        stage ('Run test') {
            steps {
               sh "./gradlew -Denv=${env} -Dselenoid.hub.url=${server}/wd/hub sub:on-test"
            }
        }
    }
     post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: "sub/reports/${env}/allure-results"]]
        }
     }
}