pipeline{
    agent any 
    stages{
        stage('No-op'){
            steps{
                sh 'ls'
                sh 'echo "FAIL"; exit 1'
            }
        }
    }
    post{
        always{
            echo 'Sempre será executado'
            deleteDir() /* limpa a workspace */
        }
        success{
            echo 'Sucesso...'
        }
        unstable{
            echo 'Não estável'
        }
        failure{
            echo 'Falhou...'
            mail to: 'rodrigo.rs.1989@gmail.com', 
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}", 
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
        changed{
            echo 'Mudou estado'
        }
    }
}