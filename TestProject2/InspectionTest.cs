using NUnit.Framework;

namespace TestProject2
{
   [TestFixture]
   public class InspectionTest
   {
       private int m_Id = 15;
       private static int s_Id = 30;
       
       [Test]
       public void Then_it_should()
       {
           Assert.AreEqual(15, m_Id);
           Assert.AreEqual(30, s_Id);
       }
   }
}
