using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
    public class UnitTest26
    {
        
        public void Test1()
        {
        }

        [Fact]
        public void Test2(string str)
        {
			Assert.False(false, str);
        }
    }
}
