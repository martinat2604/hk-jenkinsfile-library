def call() {

pipeline{

    agent any

    stages{
         
        stage('Git Checkout'){
          when { expression {  params.action == 'create' } }
            steps{
            gitCheckout(
                branch: "master",
                url: "https://github.com/martinat2604/hk-test-java-app.git"
            )
          }
        }
    }
  }
}

 
