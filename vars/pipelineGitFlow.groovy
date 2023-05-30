def call(body) {
  
def pipelineParams = [:]    
body.resolveStrategy = Closure.DELEGATE_FIRST
body()
    def jobNameParts = env.JOB_NAME.tokenize('/') as String[]
    env.JOB_CONSOLE_NAME =  (jobNameParts.length < 2 ) ? env.JOB_NAME : jobNameParts[jobNameParts.length - 2]

pipeline{
    agent any
    stages{

// Here we will call the  git checkout library.groovy       
    //   This will be used to git checkout with particular branch specific
        
        // stage('Git Checkout'){
        //     steps{
        //     libgitCheckOut(
        //         branch: "master",
        //         url: "https://github.com/martinat2604/hk-test-java-app.git"
        //     )
        //   }
        // }

        stage('Git Check'){
            steps{
            libgitCheckOut(
                branch: "$GIT_BRANCH",
                url: "$GIT_URL"
            )
          }
        }
    }
  }
}



 
