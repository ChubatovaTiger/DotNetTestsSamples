using NUnit.Framework;
using System;
using System.Threading;

[TestFixture(1, 2, TypeArgs = new Type[] { typeof(int), typeof(int) })]
public class nUNitWithDisplayName
{
    private T1 customerType;
    private T2 minOrder;

    public nUNitWithDisplayName(T1 customerType, T2 minOrder)
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
