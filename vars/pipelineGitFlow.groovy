def call(body) {

pipeline{
    agent any
    stages{
         
        stage('Git Checkout'){
            steps{
              // checkout scmGit(
              //   branches: [[name: '*/master']],
              //   extensions: [], 
              //   userRemoteConfigs: [[url: 'https://github.com/martinat2604/hk-test-java-app.git']])

              // checkout scmGit(
              //   branches: [[name: '*/master']],
              //   extensions: [], 
              //   userRemoteConfigs: [[url: 'https://github.com/martinat2604/hk-test-java-app.git']])

            gitCheckout(
                branch: "master",
                url: "https://github.com/martinat2604/hk-test-java-app.git"
            )
          }
        }
    }
  }
}

 
