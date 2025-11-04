using NUnit.Framework;
using System;
namespace TestProject2
{
    [TestFixture]
    public class SimpleTests
    {
        [Test]
        public void Addition_ShouldReturnCorrectSum()
        {
           Assert.That(2 + 2, Is.EqualTo(4));
        }
        [Test]
public void TestThatSometimesFails()
{
    Assert.That(new Random().Next(0, 2) == 1);
}
    }
}
