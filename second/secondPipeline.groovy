pipeline{
    agent any 
    stages{
        stage('Deploy'){
            steps{
                retry(3){
                    sh './second/flakey-deploy.sh'
                }

                timeout(time: 3, unit: 'MINUTES'){
                    sh './second/health-check.sh'
                }
            }
        }
    }
}