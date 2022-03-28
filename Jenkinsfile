pipeline {
    agent {
        docker {
            image 'gradle:6.9.2-jdk8'
            reuseNode true
        }
    }

    stages {
        stage ('on-test') {
            steps {
                sh "./gradlew -Denv=${env} on-test"
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: "reports/${env}/allure-results"]]
        }
    }
}