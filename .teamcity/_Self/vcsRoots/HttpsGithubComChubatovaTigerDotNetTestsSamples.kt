package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComChubatovaTigerDotNetTestsSamples : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/DotNetTestsSamples"
    url = "https://github.com/ChubatovaTiger/DotNetTestsSamples"
    branch = "refs/heads/simpletest"
    branchSpec = "refs/heads/(*)"
})
