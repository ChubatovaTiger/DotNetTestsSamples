package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.nugetCache
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object TestWholeSolution2 : BuildType({
    name = "testWholeSolution (2) (1)"

    params {
        param("env.MSBuildSDKsPath", """C:\Program Files\dotnet\sdk\8.0.201\Sdks""")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            args = "-p:RestorePackagesPath=mumu"
            logging = DotnetTestStep.Verbosity.Detailed
            sdk = "7"
        }
        dotnetTest {
            name = "New build step"
            id = "dotnet_1"
            enabled = false
            projects = "TestProject1/TestProject1.csproj"
            logging = DotnetTestStep.Verbosity.Detailed
            sdk = "7"
        }
    }

    features {
        nugetCache {
        }
    }

    requirements {
        contains("teamcity.agent.name", "agentNode1-1")
    }
})
