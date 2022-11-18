for (($i = 0); $i -lt 1000; $i++)
{
 $m='UnitTest' + $i;
 (Get-Content .\xUnit.cs) -Replace 'UnitTest', $m | Set-Content .\xUnit$i.cs
}
