using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace TestProject3
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
        }
        
        [DataTestMethod]
        [DataRow( "Aa", "Bb")]
        [DataRow( "Xx", "Yy")] baa
        public void MSTestDataRowTestMethod2(string str1, string str2)
        {
        }
    }
}
