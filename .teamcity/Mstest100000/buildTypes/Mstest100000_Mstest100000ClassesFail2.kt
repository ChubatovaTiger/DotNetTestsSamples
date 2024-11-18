package Mstest100000.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.triggers.finishBuildTrigger

object Mstest100000_Mstest100000ClassesFail2 : BuildType({
    name = "mstest100.000ClassesFail2"

    vcs {
        root(Mstest100000.vcsRoots.Mstest100000_MStestManyTests20000)
    }

    steps {
        dotnetTest {
            projects = "TestProject3/TestProject3.csproj"
            sdk = "7"
        }
    }

    triggers {
        finishBuildTrigger {
            enabled = false
            buildType = "${Mstest100000_Mstest100000ClassesFail2.id}"
        }
    }

    features {
        parallelTests {
            enabled = false
            numberOfBatches = 3
        }
    }
})
