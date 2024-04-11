using NUnit.Framework;
using System;
using System.Threading;

[TestFixture(typeof(double), typeof(int), 100.0, 42)]
[TestFixture(typeof(int) typeof(double), 42, 100.0)]
public class NUnitTest3<T1, T2>
{
    T1 t1;
    T2 t2;

    public SpecifyBothSetsOfArgs(T1 t1, T2 t2)
    {
        this.t1 = t1;
        this.t2 = t2;
    }

    [TestCase(5, 7)]
    public void TestMyArgTypes(T1 t1, T2 t2)
    {
        Assert.That(t1, Is.TypeOf<T1>());
        Assert.That(t2, Is.TypeOf<T2>());
    }
}
