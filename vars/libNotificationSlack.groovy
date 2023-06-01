// def call(String buildStatus) {

//     // build status of null means successful
//     buildStatus = buildStatus ?: 'SUCCESS'  // if the buildStatus variable is null or undefined, it will be assigned the value 'SUCCESS'. If buildStatus already has a value (not null or undefined), it will retain that value.

//     // Default values
//     def color = 'RED'
//     def colorCode = '#FF0000'
//     def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
//     def summary = "${subject} (${env.BUILD_URL})"
//     // def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
//     // <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

//   if ( buildStatus == "SUCCESS" ) {
//     slackSend channel: 'java', color: "good", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
//   }
//   else if( buildStatus == "FAILURE" ) { 
//     slackSend channel: 'java', color: "danger", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
//   }
//   else if( buildStatus == "UNSTABLE" ) { 
//     slackSend channel: 'java', color: "warning", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
//   }
//   else {
//     slackSend channel: 'java', color: "good", failOnError: true, notifyCommitters: true, teamDomain: 'optus-nzp9955', tokenCredentialId: 'slack-integration-1', factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
//   }
// }

 
