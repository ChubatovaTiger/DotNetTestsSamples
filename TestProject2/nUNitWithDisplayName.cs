using NUnit.Framework;
using System;
using System.Threading;

[TestFixture(1, 2, TypeArgs = new Type[] { typeof(int), typeof(int) })]
public class nUNitWithDisplayName(int a, int b)
{
    private T1 customerType;
    private T2 minOrder;

    public nUNitWithDisplayName<T1,T2>
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
