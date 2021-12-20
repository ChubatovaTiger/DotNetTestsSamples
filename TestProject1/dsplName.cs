using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
    public class dsplNameXunit1
    {
        [Fact(DisplayName = "dpNameChubatova12")]
        public void Test1chubatova2()
        {
            Assert.Equal("a", "b");
        }

        [Theory(DisplayName = "dpNameChubatova2")]
        [InlineData("a")]
        [InlineData("b")]
        [InlineData("c")]
        [InlineData("d")]
        public void Test2chubatova(string str)
        {
            Assert.Equal("a", "a");
        }
    }
    
    
    public class dsplNameXunit2
    {
        [Fact(DisplayName = "dpNameChubatova32")]
        public void Test2chubatova2()
        {
        }

        [Theory(DisplayName = "dpNameChubatova4")]
        [InlineData("a")]
        [InlineData("b")]
        [InlineData("c")]
        [InlineData("d")]
        public void Test2chubatova(string str)
        {
            Assert.Equal(str, "a");
        }
    }
}
