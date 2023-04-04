using NUnit.Framework;
using System;
using System.Threading;

namespace TestProject2
{
    [TestFixture(1, 2)]
    public class NUnitTest2(int a, int b){
        [TestCase(3, 4)]
        public void MyTest(int c, d) {}
    }
}
