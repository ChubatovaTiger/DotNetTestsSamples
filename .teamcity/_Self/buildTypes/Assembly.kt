package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest

object Assembly : BuildType({
    templates(M)
    name = "assembly"

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
            enabled = false
            projects = "wd/TestProject2/TestProject2.csproj"
            maxRetries = "%retrycount%"
        }
        dotnetTest {
            id = "dotnet_3"
            projects = """"op\TestProject1.dll" "op\TestProject2.dll""""
            skipBuild = true
            singleSession = true
            logging = DotnetTestStep.Verbosity.Detailed
        }
        stepsOrder = arrayListOf("dotnet", "dotnet_1", "dotnet_2", "dotnet_3")
    }

    features {
        parallelTests {
            id = "parallelTests"
            enabled = false
            numberOfBatches = 2
        }
    }
})
