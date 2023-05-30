 def call(Map stageParams) {
 
    // checkout([
    //     $class: 'GitSCM',
    //     branches: [[name:  stageParams.branch ]],
    //     userRemoteConfigs: [[ url: stageParams.url ]]
    // ])

sh "printenv | sort"
                    checkout scm
                    script {
                        env.LATEST_JAR_MAJOR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1|cut -d. -f1').trim()
                        env.LATEST_JAR_MINOR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1|cut -d. -f2').trim()
                        env.LATEST_JAR_VERSION = sh(returnStdout: true, script: 'cat gradle.properties| grep "version="|cut -d= -f2|cut -d- -f1').trim()
                        env.VERSION = env.LATEST_JAR_MAJOR_VERSION + "." + env.LATEST_JAR_MINOR_VERSION + "." + env.BUILD_NUMBER
                        echo env.VERSION
                    }

  }



   



 
