
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;
using System;


namespace TestProject1
{
    public class Tests
    {
        public class Employee
        {
            public string FirstName;
            public string LastName;

        }
        public class EmployeeTestData : IEnumerable<object[]>
        {
            public IEnumerator<object[]> GetEnumerator()
            {
                for (int i = 0; i < 50000; i++)
                {
                    yield return new object[] { new Employee { FirstName = i.ToString(), LastName = i.ToString() } };
                }
            }
            IEnumerator IEnumerable.GetEnumerator()
            {
                return GetEnumerator();
            }
        }

        [Theory]
        [ClassData(typeof(EmployeeTestData))]
        public void myTest(Employee employee)
        {
            //var Act = new Func<string>(() => _unitUnderTest.GetFullName(employee.FirstName, employee.LastName));
            Assert.Equal(employee.FirstName, employee.LastName);
        }
    }
}
