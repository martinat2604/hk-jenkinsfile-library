
// This is used for git checkout with the help of Map 


def call(Map stageParams) {

        sh "printenv | sort"  // It will print all the environment variables in the pipeline.

        checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ])

        script {
          env.LATEST_JAR_MAJOR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1|cut -d. -f1').trim()
          env.LATEST_JAR_MINOR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1|cut -d. -f2').trim()
          env.LATEST_JAR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1').trim()
          env.VERSION = env.LATEST_JAR_MAJOR_VERSION + "." + env.LATEST_JAR_MINOR_VERSION + "." + env.BUILD_NUMBER
          echo env.VERSION
            
    }
}


   



 
