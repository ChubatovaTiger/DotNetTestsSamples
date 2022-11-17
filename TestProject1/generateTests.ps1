for (($i = 0); $i -lt 100000; $i++)
{
 $m='UnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTestUnitTest' + $i;
 (Get-Content .\xUnit.cs) -Replace 'UnitTest1', $m | Set-Content .\xUnit$i.cs
}
