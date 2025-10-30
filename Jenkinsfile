pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/bhavicodesIndia/KafkaProducerConsumer.git'
            }
        }

        stage('Build with Maven') {
            steps {
                echo '🔨 Building project...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo '🧪 Running tests...'
                sh 'mvn test'
            }
        }

        stage('Deploy Application') {
            steps {
                echo '🚀 Deploying application...'
                sshagent(['ec2-ssh-key']) {
                    sh '''
                    scp -o StrictHostKeyChecking=no target/springbootkafka-0.0.1-SNAPSHOT.jar ubuntu@<your-ec2-ip>:/home/ubuntu/
                    ssh -o StrictHostKeyChecking=no ubuntu@<your-ec2-ip> '
                        nohup java -jar /home/ubuntu/springbootkafka-0.0.1-SNAPSHOT.jar > app.log 2>&1 &
                    '
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build and Deployment Successful!'
        }
        failure {
            echo '❌ Build or Deployment Failed!'
        }
    }
}
