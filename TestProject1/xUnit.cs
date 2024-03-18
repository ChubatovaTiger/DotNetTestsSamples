using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;
using System.Threading;


namespace TestProject1
{
    public class UnitTest
    {
        [Fact]
        public void Test1()
        {
			Assert.False(false, "1");
			 Thread.Sleep(5);
        }

        [Fact]
        public void Test2()
        {
			Assert.True();
			Thread.Sleep(5);
        }
    }
}
