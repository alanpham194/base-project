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
                                sourceFiles:"authentication/target/users.war",
                                remoteDirectory:"travala-users",
                                removePrefix:"authentication/target/"
                            ),
                            sshTransfer(
                                sourceFiles:"docker-compose.yml",
                                remoteDirectory:"travala-users"
                            ),
                            sshTransfer(
                               sourceFiles:"deployment/start.sh",
                               remoteDirectory:"travala-users",
                               removePrefix: "deployment/"
                            ),
                            sshTransfer(
                                //exec commands
                                execCommand: 'chmod +x /home/ubuntu/travala/travala-users/start.sh & /home/ubuntu/travala/travala-users/start.sh'
                            )
                        ])
                ])
            }
        }
    }
}