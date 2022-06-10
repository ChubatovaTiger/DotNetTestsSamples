using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;
using System.Threading;


namespace TestProject1
{
    public class UnitTest77
    {
        [Fact]
        public void Test1()
        {
			Assert.False(false, "1");
			 Thread.Sleep(500);
        }

        [Fact]
        public void Test2()
        {
			Assert.False(false, "2");
			Thread.Sleep(500);
        }
    }
}
