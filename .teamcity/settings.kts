import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.approval
import jetbrains.buildServer.configs.kotlin.buildFeatures.gradleCache
import jetbrains.buildServer.configs.kotlin.buildFeatures.mavenCache
import jetbrains.buildServer.configs.kotlin.buildFeatures.nugetCache
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

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

version = "2024.07"

project {

    buildType(Test11)
    buildType(Test)
    buildType(Test_2)
    buildType(Test1)

    params {
        param("teamcity.internal.depcache.buildFeature.gradle.enabled", "true")
        param("teamcity.internal.depcache.buildFeature.dotnet.enabled", "true")
    }
}

object Test : BuildType({
    name = "test"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            sdk = "6"
        }
    }

    features {
        nugetCache {
        }
        mavenCache {
        }
        approval {
            approvalRules = "user:admin"
        }
        gradleCache {
        }
    }
})

object Test1 : BuildType({
    name = "test (1) (1)"

    params {
        param("env.NUGET_PACKAGES", "/Users/nastasia.chubatova/mu mu2")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            sdk = "6"
        }
    }

    features {
        nugetCache {
        }
    }
})

object Test11 : BuildType({
    name = "test (1) (1) (1)"

    params {
        param("env.NUGET_PACKAGES", "/Users/nastasia.chubatova/mu mu2")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            sdk = "6"
        }
    }

    features {
        nugetCache {
        }
    }
})

object Test_2 : BuildType({
    name = "test (1)"

    params {
        param("env.NUGET_PACKAGES", "/Users/nastasia.chubatova/mu mu2")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            sdk = "6"
        }
    }

    features {
        nugetCache {
        }
    }
})
