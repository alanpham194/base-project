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
                                sourceFiles:"searching/target/searching.war",
                                remoteDirectory:"travala-searching",
                                removePrefix:"searching/target/"
                            ),
                            sshTransfer(
                                sourceFiles:"docker-compose.yml",
                                remoteDirectory:"travala-searching"
                            ),
                            sshTransfer(
                               sourceFiles:"deployment/start.sh",
                               remoteDirectory:"travala-searching",
                               removePrefix: "deployment/"
                            ),
                            sshTransfer(
                                //exec commands
                                execCommand: 'chmod +x /home/ubuntu/travala/travala-searching/start.sh & /home/ubuntu/travala/travala-searching/start.sh'
                            )
                        ])
                ])
            }
        }
    }
}