package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object Xunit999flaky : BuildType({
    name = "xunit999flaky"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComChubatovaTigerDotNetTestsSamples1)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            maxRetries = "20"
            sdk = "7"
        }
    }
})
