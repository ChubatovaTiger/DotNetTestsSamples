using NUnit.Framework;
using System;
using System.Threading;

[TestFixture(1, 1, TypeArgs = new Type[] { typeof(int), typeof(int) })]
public class NUnitTest2
{
    private T1 customerType;
    private T2 minOrder;

    public NUnitTest2(T1 customerType, T2 minOrder)
    {
        this.customerType = customerType;
        this.minOrder = minOrder;
    }

    [TestCase]
    public void TestMethod()
    {
        Assert.That(customerType, Is.TypeOf<int>());
        Assert.That(minOrder, Is.TypeOf<int>());
    }
}
