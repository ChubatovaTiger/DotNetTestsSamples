import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2023.11"

project {

    buildType(Vbn)
}

object Vbn : BuildType({
    name = "vbn"

    params {
        param("avavava", "gh")
        param("bla", "3")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        step {
            id = "HttpsGithubComChubatovaTigerDotNetTestsSamples_VbnMR"
            type = "HttpsGithubComChubatovaTigerDotNetTestsSamples_VbnMR"
            executionMode = BuildStep.ExecutionMode.DEFAULT
            param("teamcity.step.phase", "")
            param("bla", "3")
        }
        script {
            id = "simpleRunner"
            scriptContent = "echo %avavava%"
        }
    }
})
