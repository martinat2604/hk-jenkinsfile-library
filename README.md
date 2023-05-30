# hk-jenkinsfile-library
We will create all the all the steps of pipeline groovy scripts

### def call(body)
The call method allows you to define a closure that can be invoked with a body of code. The body parameter represents the closure's body, which is the code that will be executed when the closure is called.

### def pipelineParams = [:]
The line def pipelineParams = [:] is used to define an empty map in Groovy. It initializes the variable pipelineParams as an empty map object.

### body.resolveStrategy = Closure.DELEGATE_FIRST
The line body.resolveStrategy = Closure.DELEGATE_FIRST is used to configure the resolution strategy for a closure. In Groovy, the resolution strategy determines how variables and methods are resolved within a closure.

