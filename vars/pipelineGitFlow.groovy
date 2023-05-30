def call(body) {

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


 
