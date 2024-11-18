package Mstest100000

import Mstest100000.buildTypes.*
import Mstest100000.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("Mstest100000")
    name = "mstest100.000"

    vcsRoot(Mstest100000_MStestManyTests20000)

    buildType(Mstest100000_Mstest100000ClassesFail)
    buildType(Mstest100000_Mstest100000ClassesFail2)
    buildType(Mstest100000_Mstest100000ClassesFailWithRetry)
})
