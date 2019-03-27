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
                                        //exec commands
                                        execCommand: 'echo "done build................."'
                                    )
                                ])
                        ])
            }
        }
    }
}