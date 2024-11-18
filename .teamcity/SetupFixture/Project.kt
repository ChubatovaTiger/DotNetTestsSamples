package SetupFixture

import SetupFixture.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("SetupFixture")
    name = "SetupFixture"

    buildType(SetupFixture_STpFxtr)
})
