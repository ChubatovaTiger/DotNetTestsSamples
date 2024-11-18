package ManyTests.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object ManyTests_Retest : BuildType({
    name = "retest"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComChubatovaTigerDotNetTestsSamples)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            filter = "FullyQualifiedName!~UnitTestUnitTestUnitTest"
            maxRetries = "3"
            sdk = "7"
        }
    }
})
