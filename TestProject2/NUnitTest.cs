using NUnit.Framework;

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
    }
}
