pipeline{
    agent any 
    stages{
        stage('Deploy'){
            steps{
                retry(3){
                    sh 'chmod +x second/flakey-deploy.sh'
                    sh './second/flakey-deploy.sh'
                }

                timeout(time: 3, unit: 'MINUTES'){
                    sh 'chmod +x second/health-check.sh'
                    sh './second/health-check.sh'
                }
            }
        }
    }
}