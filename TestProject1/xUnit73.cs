using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
    public class UnitTest73
    {
        [Fact]
        public void Test1()
        {
        }

        [Theory]
        [InlineData("a")]
        [InlineData("b")]
        public void Test2(string str)
        {
        }
    }
}
