package ManyTests

import ManyTests.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("ManyTests")
    name = "ManyTests"

    buildType(ManyTests_Net7)
    buildType(ManyTests_Retest)
})
