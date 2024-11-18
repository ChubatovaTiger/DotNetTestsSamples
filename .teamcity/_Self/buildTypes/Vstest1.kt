package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.nugetCache
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetMsBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetVsTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetVsTest
import jetbrains.buildServer.configs.kotlin.matrix

object Vstest1 : BuildType({
    templates(M)
    name = "vstest1"

    params {
        param("env.MSBuildSDKsPath", """C:\Program Files\dotnet\sdk\8.0.201\Sdks""")
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
            enabled = false
            projects = "wd/TestProject2/TestProject2.csproj"
            maxRetries = "%retrycount%"
        }
        dotnetMsBuild {
            id = "dotnet_2"
            projects = "wd/dotnettests.sln"
            version = DotnetMsBuildStep.MSBuildVersion.CrossPlatform
            sdk = "8"
        }
        dotnetVsTest {
            id = "dotnet_3"
            enabled = false
            assemblies = """"op\TestProject*.dll""""
            excludedAssemblies = """"op\TestProject1.dll""""
            version = DotnetVsTestStep.VSTestVersion.V17
            maxRetries = "4"
            logging = DotnetVsTestStep.Verbosity.Quiet
            platform = DotnetVsTestStep.Platform.Auto
            param("dotNetCoverage.dotCover.filters", "+:*")
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.bundled%")
        }
        dotnetVsTest {
            name = "New build step"
            id = "dotnet_3_1"
            assemblies = """"op\TestProject*.dll""""
            excludedAssemblies = """"op\TestProject2.dll""""
            version = DotnetVsTestStep.VSTestVersion.V15
            maxRetries = "4"
            logging = DotnetVsTestStep.Verbosity.Quiet
            platform = DotnetVsTestStep.Platform.Auto
            param("dotNetCoverage.dotCover.filters", "+:*")
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.bundled%")
        }
        stepsOrder = arrayListOf("dotnet", "dotnet_1", "dotnet_2", "dotnet_3", "dotnet_3_1")
    }

    features {
        parallelTests {
            id = "parallelTests"
            enabled = false
            numberOfBatches = 2
        }
        matrix {
            id = "matrix"
            enabled = false
            param("a", listOf(
                value("1"),
                value("2")
            ))
        }
        nugetCache {
            id = "dependencyCache.dotnet"
        }
    }
})
