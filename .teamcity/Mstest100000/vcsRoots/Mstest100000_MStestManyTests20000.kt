package Mstest100000.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object Mstest100000_MStestManyTests20000 : GitVcsRoot({
    name = "MStestManyTests100000"
    url = "https://github.com/ChubatovaTiger/MStestManyTests"
    branch = "refs/heads/100000fail"
})
