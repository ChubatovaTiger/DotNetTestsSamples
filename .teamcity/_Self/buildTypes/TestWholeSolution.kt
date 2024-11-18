package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.nugetCache
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object TestWholeSolution : BuildType({
    name = "testWholeSolution (1)"

    params {
        param("env.MSBuildSDKsPath", """C:\Program Files\dotnet\sdk\8.0.201\Sdks""")
    }

    vcs {
        root(DslContext.settingsRoot, ".=>test")
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "test/TestProject1/TestProject1.csproj"
            logging = DotnetTestStep.Verbosity.Detailed
            sdk = "7"
        }
    }

    features {
        nugetCache {
        }
    }
})
