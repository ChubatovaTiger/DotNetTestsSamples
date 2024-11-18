package _Self

import _Self.buildTypes.*
import _Self.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudImage
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudProfile

object Project : Project({

    vcsRoot(HttpsGithubComChubatovaTigerDotNetTestsSamples1)
    vcsRoot(HttpsGithubComChubatovaTigerDotNetTestsSamples)

    buildType(Net7)
    buildType(Net7SettingsFile)
    buildType(Assembly)
    buildType(WholeSolution)
    buildType(TestWholeSolution)
    buildType(TestWholeSolution2)
    buildType(Vstest1)
    buildType(TestWholeSolution_2)
    buildType(Xunit999flaky)
    buildType(FlakyParametrized)

    template(M)

    params {
        param("teamcity.internal.depcache.buildFeature.dotnet.enabled", "true")
    }

    features {
        amazonEC2CloudImage {
            id = "PROJECT_EXT_122"
            profileId = "amazon-10006"
            name = "winRetryDotnet"
            vpcSubnetId = "subnet-043178c302cabfe37"
            keyPairName = "chubatova-amazon-ireland"
            instanceType = "m2.xlarge"
            securityGroups = listOf("sg-072d8bfa0626ea2a6")
            userScript = "echo 1 > a.txt"
            source = Source("ami-07a804dd17458af2e")
        }
        amazonEC2CloudProfile {
            id = "amazon-10006"
            name = "awsWinDotnetRetry2"
            serverURL = "http://10.128.93.78:8111"
            terminateIdleMinutes = 0
            region = AmazonEC2CloudProfile.Regions.EU_WEST_DUBLIN
            authType = accessKey {
                keyId = "credentialsJSON:f828d4b9-90ad-437c-ba9a-71caad6cfa44"
                secretKey = "credentialsJSON:c983f743-88ca-4a7e-8374-174a978a9b92"
            }
        }
    }

    subProject(Mstest100000.Project)
    subProject(SetupFixture.Project)
    subProject(ManyTests.Project)
})
