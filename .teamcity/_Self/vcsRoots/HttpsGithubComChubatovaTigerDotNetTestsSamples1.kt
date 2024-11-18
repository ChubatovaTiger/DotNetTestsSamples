package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComChubatovaTigerDotNetTestsSamples1 : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/DotNetTestsSamples (1)"
    url = "https://github.com/ChubatovaTiger/DotNetTestsSamples"
    branch = "refs/heads/simpletest"
    branchSpec = "refs/heads/(*)"
    authMethod = password {
        userName = "ChubatovaTiger"
        password = "credentialsJSON:b52775aa-53a6-4ee8-8b8f-79503fa059b2"
    }
})
