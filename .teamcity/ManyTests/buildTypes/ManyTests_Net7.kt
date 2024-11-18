package ManyTests.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.triggers.retryBuild

object ManyTests_Net7 : BuildType({
    name = "net7"

    params {
        password("system.sec", "credentialsJSON:28b49ea4-3564-4ea6-a5b6-1cbf235dabe6")
        password("env.sec", "credentialsJSON:410cbd8a-b6cf-4ee5-89de-cc751321e2d2")
        param("retrycount", "2")
    }

    vcs {
        root(_Self.vcsRoots.HttpsGithubComChubatovaTigerDotNetTestsSamples)

        branchFilter = "+:main"
    }

    steps {
        dotnetTest {
            name = "ь"
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            maxRetries = "3"
            sdk = "7"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.bundled%")
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
