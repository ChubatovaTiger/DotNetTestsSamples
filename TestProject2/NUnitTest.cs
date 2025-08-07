using NUnit.Framework;

namespace TestProject2
{
    [TestFixture]
    public class SimpleTests
    {
        [Test]
        public void Addition_ShouldReturnCorrectSum()
        {
            Assert.AreEqual(5, 5);
        }
    }
}
