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
    slackSend channel: 'java', color: "good", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend channel: 'danger', color: "good", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend channel: 'warning', color: "good", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
  }
  else {
    slackSend channel: 'java', color: "good", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
  }
}

 
