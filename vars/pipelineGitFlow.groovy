def call(body) {
  
def pipelineParams = [:]    
body.resolveStrategy = Closure.DELEGATE_FIRST
body()
    def jobNameParts = env.JOB_NAME.tokenize('/') as String[]
    env.JOB_CONSOLE_NAME =  (jobNameParts.length < 2 ) ? env.JOB_NAME : jobNameParts[jobNameParts.length - 2]
pipeline{
    agent any
    stages{
              
        stage('Git Checkout'){
            steps{
            libgitCheckOut(
                branch: "master",
                url: "https://github.com/martinat2604/hk-test-java-app.git"
            )
          }
        }
    }
  }
}


 
