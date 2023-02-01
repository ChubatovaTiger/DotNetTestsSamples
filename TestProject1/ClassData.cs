
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
public class TestDataGenerator : IEnumerable<object[]>
{
    private readonly List<object[]> _data = new List<object[]>
    {
       List.Add({5});
       List.Add({6});
    };

    public IEnumerator<object[]> GetEnumerator() => _data.GetEnumerator();

    IEnumerator IEnumerable.GetEnumerator() => GetEnumerator();
}

public class ParameterizedTests
{
    public bool IsOddNumber(int number)
    {
        return number % 2 != 0;
    }

    [Theory]
    [ClassData(typeof(TestDataGenerator))]
    public void AllNumbers_AreOdd_WithClassData(int a)
    {
        Assert.True(IsOddNumber(a));
        Assert.True(IsOddNumber(b));
        Assert.True(IsOddNumber(c));
        Assert.True(IsOddNumber(d));
    }
}
}
