using NUnit.Framework;

namespace TestProject2
{
    public class UnitTest1
    {
        [SetUp]
        public void Setup()
        {
        }
 //[Ignore("Ignore a test")]
        [Test]
        public void Test1NunitSimplever1()
        {
            Assert.Fail();
        }
        
         //[Ignore("Ignore a test")]
        [Test]
         [Category("Short")]
        [TestCase("chrome", "72.0", "Windows 10")]
        [TestCase("internet explorer", "11.0", "Windows 10")]
        public void Test2(string str1, string str2, string str3)
        {
            Assert.Pass();
        }
        

         //[Ignore("Ignore a test")]
        [Test, Sequential]
         [Category("Long")]
        public void NunitSequentialParametersTest(
         [Values(1,2,3)] int x,
        [Values("A","B")] string s)
        {
         Assert.Pass();
        }

     //[Ignore("Ignore a test")]    
[Test]
[Category("Long")]
public void NUnitRangeTest(
    [Values(1, 2, 3)] int x,
    [Range(0.2, 0.6, 0.2)] double d)
{
    Assert.Pass();
}
     
        
        
        
    }
}
