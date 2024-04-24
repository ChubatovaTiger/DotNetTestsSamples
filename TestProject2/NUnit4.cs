using NUnit.Framework;
using System;
using System.Threading;
using System.Collections; 
using System.Collections.Generic;



#pragma warning disable NUnit2041 // Incompatible types for comparison constraint
#pragma warning disable NUnit1001 // The individual arguments provided by a TestCaseAttribute must match the type of the corresponding parameter of the method
  
[TestFixture(100.0, 42)]
[TestFixture(42, 100.0)]
[TestFixture(0, 5.0)] // fails
public class DeduceTypeArgsFromArgs<T1, T2>
    where T1 : notnull
    where T2 : notnull
{
    private readonly T1 _t1;
    private readonly T2 _t2;

    public DeduceTypeArgsFromArgs(T1 t1, T2 t2)
    {
        _t1 = t1;
        _t2 = t2;
    }

    [TestCase(5, 7)]
    public void TestMyArgTypes(T1 t1, T2 t2)
    {
        Assert.That(t1, Is.TypeOf<T1>());
        Assert.That(t1, Is.LessThan(_t1));

        Assert.That(t2, Is.TypeOf<T2>());
        Assert.That(t2, Is.LessThan(_t2));
    }
}
