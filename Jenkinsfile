pipeline {
    agent {label 'slave-maven'}
    stages {
        stage('Install dependencies') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Deploy to server'){
            steps{
                echo "Deploy................"
                sh 'ls'
                sh 'pwd'
                sshPublisher(
                    publishers:[
                        sshPublisherDesc(configName:'travala_dev_server',verbose:true,transfers:[
                            sshTransfer(
                                sourceFiles:"orders/target/orders.war",
                                remoteDirectory:"travala-orders",
                                removePrefix:"orders/target/"
                            ),
                            sshTransfer(
                                sourceFiles:"docker-compose.yml",
                                remoteDirectory:"travala-orders"
                            ),
                            sshTransfer(
                               sourceFiles:"deployment/start.sh",
                               remoteDirectory:"travala-orders",
                               removePrefix: "deployment/"
                            ),
                            sshTransfer(
                                //exec commands
                                execCommand: 'chmod +x /home/ubuntu/travala/travala-orders/start.sh & /home/ubuntu/travala/travala-orders/start.sh'
                            )
                        ])
                ])
            }
        }
    }
}