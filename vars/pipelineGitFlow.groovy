def call(body) {
  
def pipelineParams = [:]    
body.resolveStrategy = Closure.DELEGATE_FIRST
body()
    def jobNameParts = env.JOB_NAME.tokenize('/') as String[]
    env.JOB_CONSOLE_NAME =  (jobNameParts.length < 2 ) ? env.JOB_NAME : jobNameParts[jobNameParts.length - 2]


pipeline{
    agent any
    stages{

            // stage('Checkout') {
            //     steps {
            //         sh "printenv | sort"
            //         checkout scm
            //         script {
            //             env.LATEST_JAR_MAJOR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1|cut -d. -f1').trim()
            //             env.LATEST_JAR_MINOR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1|cut -d. -f2').trim()
            //             env.LATEST_JAR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1').trim()
            //             env.VERSION = env.LATEST_JAR_MAJOR_VERSION + "." + env.LATEST_JAR_MINOR_VERSION + "." + env.BUILD_NUMBER
            //             echo env.VERSION
            //         }
              
        // stage('Git Checkout'){
        //     steps{
        //     libgitCheckOut(
        //         branch: "master",
        //         url: "https://github.com/martinat2604/hk-test-java-app.git"
        //     )
        //   }
        // }

        stage('Git Checkout'){
            steps{
            libgitCheckOut()
          }
        }
    }
  }
}



 
