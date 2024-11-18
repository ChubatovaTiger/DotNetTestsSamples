package SetupFixture.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object SetupFixture_STpFxtr : BuildType({
    name = "sTpFxtr"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComChubatovaTigerDotNetTestsSamples)

        branchFilter = "+:Fixtures"
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "TestProject2/TestProject2.csproj"
            maxRetries = "3"
            sdk = "7"
        }
    }
})
