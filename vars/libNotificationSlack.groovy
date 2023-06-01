def call(String buildResult) {

    // build status of null means successful
    buildResult = buildResult ?: 'SUCCESS'  // if the buildStatus variable is null or undefined, it will be assigned the value 'SUCCESS'. If buildStatus already has a value (not null or undefined), it will retain that value.

    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"
    // def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    // <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable"
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear"	
  }
}

//slackSend "<span style= 'color:${color}'><b>${buildStatus}</b></span>",color: colorCode, message: '',factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]

 
