for (($i = 0); $i -lt 100; $i++)
{
 $m='UnitTest' + $i;
 (Get-Content .\xUnit.cs) -Replace 'UnitTest1', $m | Set-Content .\xUnit$i.cs
}
