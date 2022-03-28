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
                sh "gradle -Denv=${env} sub-project-1:on-test"
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: "sub-project-1/reports/${env}/allure-results"]]
        }
    }
}