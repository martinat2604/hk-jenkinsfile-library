def call(String buildStatus = 'STARTED') {

    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESS'  // if the buildStatus variable is null or undefined, it will be assigned the value 'SUCCESS'. If buildStatus already has a value (not null or undefined), it will retain that value.

    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"
    // def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    // <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

  if ( buildStatus == 'STARTED' ) {
    color = 'YELLOW'
    colorCode = '#FFFF00'
    // slackSend "<span style= 'color:${color}'><b>${buildStatus}</b></span>",color: colorCode, message: '',factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
  }
  else if( buildStatus == 'SUCCESS' ) { 
    color = 'GREEN'
    colorCode = '#00FF00' 
  }
  else {
    color = 'RED'
    colorCode = '#FF0000'
  }
}

slackSend "<span style= 'color:${color}'><b>${buildStatus}</b></span>",color: colorCode, message: '',factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]

 
