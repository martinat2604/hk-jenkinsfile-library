// def call(String buildStatus = 'STARTED') {
//     // build status of null means successful
//     buildStatus = buildStatus ?: 'SUCCESS'  // if the buildStatus variable is null or undefined, it will be assigned the value 'SUCCESS'. If buildStatus already has a value (not null or undefined), it will retain that value.

//     // Default values
//     def colorName = 'RED'
//     def colorCode = '#FF0000'
//     def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
//     def summary = "${subject} (${env.BUILD_URL})"
//     def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
//     <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

//     // Override default values based on build status
//     if (buildStatus == 'STARTED') {
//         color = 'YELLOW'
//         colorCode = '#FFFF00'
//     } else if (buildStatus == 'SUCCESS') {
//         color = 'GREEN'
//         colorCode = '#00FF00'
//     } else {
//         color = 'RED'
//         colorCode = '#FF0000'
//     }

//     // Send Microsoft Teams notifications
//     office365ConnectorSend status: "<span style='color:${color}'><b>${buildStatus}</b></span>",color: colorCode, message: '', webhookUrl: "${env.MS_TEAMS_URL}",factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]
// }

def call(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'
    
    // Set the Slack webhook URL
    envVars.put("SLACK_WEBHOOK_URL", "https://hooks.slack.com/services/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" + slackToken)

    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"
    def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""
    
    if (buildStatus == 'STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }
    
    slackSend status: "<span style='color:${color}'><b>${buildStatus}</b></span>",color: colorCode, message: '', webhookUrl: "${env.SLACK_WEBHOOK_URL}",factDefinitions: [[name: "Job Name", template: "${JOB_CONSOLE_NAME}"],[name: "Branch Name", template: "${BRANCH_NAME}"],[name: "Build ID", template: "${BUILD_ID}"],[name: "Version", template: "${VERSION}"]]

    def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

    slackSend(color: color, message: msg)
}

