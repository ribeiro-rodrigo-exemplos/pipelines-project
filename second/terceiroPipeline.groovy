pipeline{
    agent any 
    stages{
        stage('Deploy'){
            steps{
                timeout(time:3 unity:'MINUTES'){
                    retry(5){
                        sh 'chmod +x second/flakey-deploy.sh'
                        sh './second/flakey-deploy.sh'
                    }
                }
            }
        }
    }
}