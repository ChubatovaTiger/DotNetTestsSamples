using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
    public class UnitTest1
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
    public class XUnitFlakyTests
{
// 50% success rate
private static readonly Random Random = new();
private static bool IsFlakyTestPassed() => Random.NextDouble() > 0.5;
[Fact] public void FlakyTest1()=> Assert.True(IsFlakyTestPassed());
[Fact] public void FlakyTest2()=> Assert.True(IsFlakyTestPassed());
[Fact] public void FlakyTest3()=> Assert.True(IsFlakyTestPassed());

}
}
