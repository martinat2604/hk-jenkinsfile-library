def call(Map stageParams) {
 
checkout scmGit(
     
    branches: [[name: stageParams.branch]],
    extensions: [], 
    userRemoteConfigs: [[url: stageParams.url]])


    // checkout([
    //     $class: 'GitSCM',
    //     branches: [[name:  stageParams.branch ]],
    //     userRemoteConfigs: [[ url: stageParams.url ]]
    // ])
  }