pipeline {
    agent any
    stages {
        stage('Pull browser') {
            steps {
               catchError {
                  script {
                    docker.image('selenoid/chrome:99.0')
                  }
               }
            }
         }
        stage ('on-test') {
            steps {
                catchError {
                    script {
                        docker.image('aerokube/selenoid:1.10.4').withRun('-p 4444:4444 -v /run/docker.sock:/var/run/docker.sock -v $PWD:/etc/selenoid',
                        '-timeout 600s -limit 2') {
                            docker.image('openjdk:8u322-jdk-slim').inside("--link ${c.id}:selenoid") {
                                sh "./gradlew -Denv=qa sub:on-test"
                            }
                        }
                    }
                }
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: "sub/reports/${env}/allure-results"]]
        }
    }
}