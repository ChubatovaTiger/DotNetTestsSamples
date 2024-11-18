package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.triggers.retryBuild

object FlakyParametrized : BuildType({
    name = "flakyParametrized"

    params {
        param("retryCount2", "3")
        password("system.sec", "credentialsJSON:28b49ea4-3564-4ea6-a5b6-1cbf235dabe6")
        param("retrycount", "2")
        password("env.sec", "credentialsJSON:410cbd8a-b6cf-4ee5-89de-cc751321e2d2")
    }

    vcs {
        root(_Self.vcsRoots.HttpsGithubComChubatovaTigerDotNetTestsSamples1, "+:. => wd")

        branchFilter = "+:flaky"
    }

    steps {
        dotnetTest {
            id = "dotnet"
            enabled = false
            projects = "dotnettests.sln"
            workingDir = "wd"
            filter = "%retrycount%"
            outputDir = "blabla"
            singleSession = true
            maxRetries = "1a"
            args = """-c "Debug""""
            sdk = "7"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.bundled%")
        }
        dotnetTest {
            id = "dotnet_1"
            projects = "wd/TestProject1/TestProject1.csproj"
            maxRetries = "%retryCount2%"
        }
    }

    triggers {
        retryBuild {
            enabled = false
        }
    }

    features {
        parallelTests {
            enabled = false
            numberOfBatches = 2
        }
    }
})
