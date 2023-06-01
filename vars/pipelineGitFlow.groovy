def call(body) {
    def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body()
    def jobNameParts = env.JOB_NAME.tokenize('/') as String[]
    env.JOB_CONSOLE_NAME =  (jobNameParts.length < 2 ) ? env.JOB_NAME : jobNameParts[jobNameParts.length - 2]

    pipeline {
        agent any
        stages {
            // Here we will call the  git checkout library.groovy.
            stage('Git Checkout') {
                steps {                   
                    libgitCheckOut(
                        branch: "$GIT_BRANCH",
                        url: "$GIT_URL"
                    )
                }
            }

            stage('Unit Test Maven') {
                tools {
                    maven 'Maven 3.9.2'
                }
                steps {
                    script{
                        libmvnTest()
                    }
                }
            }
        }
    }
}
