def call () {
    sh 'mvn clean install'
    sh 'mvn test'
}