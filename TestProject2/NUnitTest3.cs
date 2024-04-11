using NUnit.Framework;
using System;
using System.Threading;
using System.Collections; 


[TestFixture(typeof(ArrayList))]
[TestFixture(typeof(List<int>))]
public class NUnitTest3<TList>
    where TList : IList, new()
{
    private IList _list = null!;

    [SetUp]
    public void CreateList()
    {
        _list = new TList();
    }

    [Test]
    public void CanAddToList()
    {
        _list.Add(1); _list.Add(2); _list.Add(3);
        Assert.That(_list, Has.Count.EqualTo(3));
    }
}
