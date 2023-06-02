def call (String channel='java') {

  env.BUILD_RESULT = currentBuild.result ?: 'SUCCESS'

  //if (env.BUILD_RESULT == 'SUCCESS') {
  //if (['UNSTABLE', 'ABORTED'].contains(env.BUILD_RESULT)) {
  switch (env.BUILD_RESULT) {
    case 'SUCCESS':
      env.SLACK_COLOR = 'good'
      env.BUILD_RESULT = env.BUILD_RESULT.toLowerCase().capitalize()
      break
    // fallthrough to set warning for either of these conditions
    case 'UNSTABLE':
    case 'ABORTED':
      env.SLACK_COLOR = 'warning'
    default:
      env.SLACK_COLOR = 'danger'
  }

  env.SLACK_USERTAGS = ''
  if (env.SLACK_COLOR != 'good') {
    env.SLACK_USERTAGS = slackBrokenCommitters().join(' ')
  }
  if (env.SLACK_USERTAGS) {
    env.SLACK_USERTAGS = '- ' + env.SLACK_USERTAGS
  }

  // $BUILD_URL       for Classic UI
  // $RUN_DISPLAY_URL for Blue Ocean UI
  env.SLACK_LINKS  = "Pipeline <$JOB_DISPLAY_URL|$JOB_NAME> - <$RUN_DISPLAY_URL|Build #$BUILD_NUMBER>"
  env.SLACK_MESSAGE = "Job $BUILD_RESULT - $SLACK_LINKS $SLACK_USERTAGS"

  slackSend (
    // works but channels seem to work with or without # prefix, making this unnecessary
    //channel: "#${channel.replaceAll('^#+', '')}",
    channel: "$channel",
    color: "$SLACK_COLOR",
    message: "$SLACK_MESSAGE",
    notifyCommitters: true,

    teamDomain: 'optus-nzp9955',
    tokenCredentialId: 'slack-integration-1'
    // notifyCommitters requires bot user
    // botUser: true,
    // override display name
  )
}