pipeline {
    agent {
        docker {
            image 'gradle:6.9.2-jdk8'
            reuseNode: true
        }
    }

    stages {
        stage ('on-test') {
            steps {
                sh "./gradlew -Denv=${env} on-test"
            }
        }

        stage ('report') {
            steps {
                sh './gradlew -Denv=qa '
            }
        }
    }
}