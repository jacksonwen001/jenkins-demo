pipeline {
    agent any
    stages {
        stage ('Run test') {
            steps {
               sh "./gradlew -Denv=${env} -Dselenoid.hub.url=${server}/wd/hub ccp-automation:on-test"
            }
        }
        post {
            always {
                allure includeProperties: false, jdk: '', results: [[path: "ccp-automation/reports/${env}/allure-results"]]
            }
        }
    }
}