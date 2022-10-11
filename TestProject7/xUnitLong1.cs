using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;
using System.Threading;


namespace TestProject7
{
    public class xUnitLong1
    {
        [Fact]
        public void Test1()
        {
             Thread.Sleep(60);
        }

        [Theory]
        [InlineData("a")]
        [InlineData("b")]
        [InlineData("c")]
         public void Test11(string str)
        {
                    Thread.Sleep(60);
                    Assert.True(str == "a");
        
        }
    }
}
