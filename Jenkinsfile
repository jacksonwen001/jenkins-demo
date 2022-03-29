pipeline {
    agent any
    stages {
//         stage('Build Image') {
//             steps {
//                 catchError {
//                     script {
//                         docker.build("automation-test", "-f Dockerfile .")
//                     }
//                 }
//             }
//         }
        stage('Pull browser') {
            steps {
               catchError {
                  script {
                    docker.image('selenoid/chrome:98.0')
                  }
               }
            }
         }
        stage ('Run test') {
            steps {
                catchError {
                    script {
                        docker.image('aerokube/selenoid:1.10.7').withRun('-p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v $PWD:/etc/selenoid/:ro',
                        '-timeout 600s -limit 2') { c ->
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
            allure includeProperties: false, jdk: '', results: [[path: "sub/reports/qa/allure-results"]]
        }
    }
}