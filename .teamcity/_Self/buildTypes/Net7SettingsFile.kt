package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object Net7SettingsFile : BuildType({
    name = "net7SettingsFile"

    params {
        password("system.sec", "credentialsJSON:28b49ea4-3564-4ea6-a5b6-1cbf235dabe6")
        password("env.sec", "credentialsJSON:410cbd8a-b6cf-4ee5-89de-cc751321e2d2")
        param("retrycount", "2")
    }

    vcs {
        root(_Self.vcsRoots.HttpsGithubComChubatovaTigerDotNetTestsSamples1, "+:. => wd")

        branchFilter = "+:runsettings"
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "dotnettests.sln"
            workingDir = "wd"
            settingsFile = "TestProject1/MyTests.runsettings"
            maxRetries = "2"
            sdk = "7"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.bundled%")
        }
    }

    features {
        parallelTests {
            numberOfBatches = 2
        }
    }
})
