pipeline{
    agent any
    stages{
        stage('Test'){
            steps{
                sh 'echo "Fail"; exit 1'
            }
        }
    }
    post{
        always{
            echo 'Isso sempre será executado'
        }
        success{
            echo 'Isso só será executado se for bem-sucedido'
        }
        failure{
            echo 'Isso só será executado se falhar'
        }
        unstable{
            echo 'Isso será executado somente se a corrida foi marcada como instável'
        }
        changed{
            echo 'Isso será executado somente se o estado do pipeline for alterado'
            echo 'Por exemplo, se o Pipeline estava falhando anteriormente, mas agora é bem-sucedido'
        }
    }
}