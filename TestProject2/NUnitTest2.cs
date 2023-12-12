using NUnit.Framework;
using System;
using System.Threading;

[TestFixture("hello", "hello", "goodbye")]
[TestFixture("zip", "zip2")]
[TestFixture(42, 42, 9)]
public class NUnitTest2
{
    private readonly string _eq1;
    private readonly string _eq2;
    private readonly string _neq;

    public NUnitTest2(string eq1, string eq2, string neq)
    {
        _eq1 = eq1;
        _eq2 = eq2;
        _neq = neq;
    }

    public NUnitTest2(string eq1, string eq2)
        : this(eq1, eq2, null) { }

    public NUnitTest2(int eq1, int eq2, int neq)
    {
        _eq1 = eq1.ToString();
        _eq2 = eq2.ToString();
        _neq = neq.ToString();
    }

    [Test]
    public void TestEquality()
    {
        Assert.That(_eq2, Is.EqualTo(_eq1));
        Assert.That(_eq2.GetHashCode(), Is.EqualTo(_eq1.GetHashCode()));
    }

    [Test]
    public void TestInequality()
    {
        Assert.That(_neq, Is.Not.EqualTo(_eq1));
        if (_neq != null)
        {
            Assert.That(_neq.GetHashCode(), Is.Not.EqualTo(_eq1.GetHashCode()));
        }
    }
}
