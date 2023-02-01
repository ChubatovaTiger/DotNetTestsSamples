
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;


namespace TestProject1
{
    
public class EmployeeTestData:IEnumerable<object[]>
    {
        public IEnumerator<object[]> GetEnumerator()
        {
            yield return new object[] {5, 1, 3, 9000};
            yield return new object[] {6, 1, 3, 9000};

        }
        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
public class ParameterizedTests
    
{
        public bool IsOddNumber(int number)
    {
        return number % 2 != 0;
    }
    
[Theory]
    [ClassData(typeof(EmployeeTestData))]
    public void Employee_GetFullName_Throw_ArgumentNullException_When_FirstName_Is(int a, int b, int c, int d)
        {
        Assert.True(IsOddNumber(a));
        }
}
    
}
