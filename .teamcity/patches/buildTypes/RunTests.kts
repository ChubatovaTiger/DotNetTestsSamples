package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.ParallelTestsFeature
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'RunTests'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("RunTests")) {
    expectSteps {
        dotnetTest {
            projects = "TestProject5/TestProject5.csproj"
            sdk = "6"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        script {
            scriptContent = "ls"
        }
        dotnetTest {
            name = "New build step"
            projects = "TestProject1/TestProject1.csproj"
            filter = "FullyQualifiedName!~UnitTest1"
            sdk = "6"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }
    steps {
        update<DotnetTestStep>(0) {
            clearConditions()
            filter = "Name!~UnitTest"
        }
        update<ScriptBuildStep>(1) {
            enabled = false
            clearConditions()
        }
    }

    features {
        val feature1 = find<ParallelTestsFeature> {
            parallelTests {
                numberOfBatches = 3
            }
        }
        feature1.apply {
            enabled = false
        }
    }
}
