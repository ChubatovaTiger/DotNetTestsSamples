
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics.Contracts;
using Xunit;



    public static IEnumerable<object[]> enumValues()
        {
            for (int i = 0; i < 5; i++)
            {
                yield return new object[] { i };
            }
        }

 [Theory]
        [MemberData("enumValues")]
        public void TestNumberGeneric(int number)
        {
            Assert.Equal(true, (Convert.ToInt32(number) > 0));
        }
