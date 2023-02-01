
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
        
            public class TestData {
      int Base {get;set;}
      int Exponent {get;set;}
      int ExpectedResult {get;set;}
    }
        
public List<TestData> PowerOfTestData() {
        yield return new TestData { Base = 0, Exponent = 0, TestData = 0 };
        yield return new TestData { Base = 0, Exponent = 1, TestData = 0 };
        yield return new TestData { Base = 2, Exponent = 0, TestData = 1 };
        yield return new TestData { Base = 2, Exponent = 1, TestData = 2 };
        yield return new TestData { Base = 5, Exponent = 2, TestData = 25 };
    }
        
        class PowerOfTestDataClass : TheoryData<int, int, int>
{
    public PowerOfTestDataClass()
    {
       Add(0, 0, 0);
       Add(0, 1, 0);
       Add(2, 0, 1);
       Add(2, 1, 2);
       Add(5, 2, 25);
    }
}

public class ParameterizedTests
{
    public bool IsOddNumber(int number)
    {
        return number % 2 != 0;
    }

    [Theory]
    [ClassData(typeof(PowerOfTestDataClass))]
    public void AllNumbers_AreOdd_WithClassData(int a, int b, int c)
    {
        Assert.True(IsOddNumber(a));
        Assert.True(IsOddNumber(b));
        Assert.True(IsOddNumber(c));
        Assert.True(IsOddNumber(d));
    }
}
}
