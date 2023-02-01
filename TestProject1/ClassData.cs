
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
            yield return new object[] { new Employee { Id = 1, FirstName = "John", LastName = "" } };
            yield return new object[] { new Employee { Id = 2, FirstName = "Mary", LastName = null } };
            yield return new object[] { new Employee { Id = 3, FirstName = "Mary", LastName = null } };
            yield return new object[] { new Employee { Id = 4, FirstName = "", LastName = null } };
            yield return new object[] { new Employee { Id = 5, FirstName = "", LastName = "john" } };
            yield return new object[] { new Employee { Id = 6, FirstName = null, LastName = " " } };
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
public void Employee_GetFullName_Throw_ArgumentNullException_When_FirstName_Is(Employee employee)
        {
            var Act = new Func<string>(() => _unitUnderTest.GetFullName(employee.FirstName, employee.LastName));
            Assert.Throws<ArgumentNullException>(Act);
        }
}
}
