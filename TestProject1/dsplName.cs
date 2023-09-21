using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
    public class dsplNameXunit1
    {
        [Fact(DisplayName = "dpNameChubatovaTigerFact1")]
        public void Test1chubatovaFact1()
        {
            Assert.Equal("a", "ba");
        }

        [Theory]
        [InlineData("a")]
        [InlineData("b")]
        [InlineData("c")]
        [InlineData("d")]
        public void Test2chubatovaTheory1noDspl(string str)
        {
            Assert.Equal("a", "a");
        }
    }
    
    
    public class dsplNameXunit2
    {
        [Fact(DisplayName = "dpNameChubatovaTigerFact2")]
        public void Test2chubatovaFact2()
        {
        }

        [Theory]
        [InlineData("a")]
        [InlineData("b")]
        [InlineData("c")]
        [InlineData("d")]
        public void Test2chubatovaTheory2noDspl(string str)
        {
            Assert.Equal(str, "a");
        }
    }
}
