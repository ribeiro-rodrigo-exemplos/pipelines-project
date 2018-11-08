pipeline{
    agent any 
    stages{
        stage('Test'){
            steps{
                script{
                    
                    def server = Artifactory.newServer 'http://142.93.254.193:8081/artifactory', 'admin', 'password'
                    
                    def promotionConfig = [

                        'buildName' : 'artifactory-pipeline', 
                        'buildNumber' : 6, 
                        'targetRepo' : 'libs-release-local', 
                        'comment' : 'aprovando para produção', 
                        'sourceRepo' : 'libs-snapshot-local', 
                        'status' : 'Released'
                        'includeDependencies' : true, 
                        'copy' : true, 
                        'failFast' : true 

                    ]

                    server.promote promotionConfig 
                }
            }
        }
    }
}