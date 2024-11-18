package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.triggers.retryBuild

object Net7 : BuildType({
    name = "net7"

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
        dotnetTest {
            id = "dotnet"
            projects = "TestProject1/TestProject1.csproj"
            workingDir = "wd"
            outputDir = "blabla"
            maxRetries = "%retrycount%"
            sdk = "7"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.bundled%")
        }
        dotnetTest {
            id = "dotnet_1"
            enabled = false
            projects = "wd/TestProject3/TestProject3.csproj"
            maxRetries = "2"
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
