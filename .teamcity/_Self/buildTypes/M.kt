package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object M : Template({
    name = "m"

    params {
        password("system.sec", "credentialsJSON:28b49ea4-3564-4ea6-a5b6-1cbf235dabe6")
        password("env.sec", "credentialsJSON:410cbd8a-b6cf-4ee5-89de-cc751321e2d2")
        param("retrycount", "2")
    }

    vcs {
        root(_Self.vcsRoots.HttpsGithubComChubatovaTigerDotNetTestsSamples1, "+:. => wd")

        branchFilter = "+:net5"
    }

    steps {
        dotnetBuild {
            id = "dotnet_2"
            projects = "wd/dotnettests.sln"
            outputDir = "op"
            sdk = "8"
        }
        dotnetTest {
            id = "dotnet_3"
            projects = """"op\TestProject1.dll" "op\TestProject2.dll""""
            skipBuild = true
            singleSession = true
            maxRetries = "2"
            logging = DotnetTestStep.Verbosity.Detailed
        }
    }
})
