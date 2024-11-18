package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.nugetCache
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetNugetPushStep
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetNugetPush
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object WholeSolution : BuildType({
    name = "testWholeSolution"

    params {
        param("env.MSBuildSDKsPath", """C:\Program Files\dotnet\sdk\8.0.201\Sdks""")
        param("env.NUGET_PACKAGES", "%teamcity.agent.work.dir%/mumu3")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dotnetNugetPush {
            id = "dotnet"
            enabled = false
            packages = "TestProject1/TestProject1.csproj"
            serverUrl = "hghg"
            apiKey = "credentialsJSON:72e14d91-dfd9-4af2-903e-d9bba436af94"
            logging = DotnetNugetPushStep.Verbosity.Detailed
            sdk = "7"
        }
        dotnetTest {
            name = "New build step"
            id = "dotnet_1"
            projects = "TestProject1/TestProject1.csproj"
            logging = DotnetTestStep.Verbosity.Detailed
            sdk = "7"
        }
    }

    features {
        nugetCache {
            //enabled = false
        }
    }

    requirements {
        contains("teamcity.agent.name", "agentNode1-1")
    }
})
