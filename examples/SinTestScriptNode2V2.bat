@echo off
cd C:\Morphy
set mc=java -jar MorphyCloud.jar 
set location=-remote@161.73.158.226
%mc% %location% loadTestSpec(file:C:\Morphy\examples\bin\SinTest.class)
%mc% %location%  makeSeed([randomValues])
%mc% %location%  makeMutants1stOrderComplete([piMinus,mid])
%mc% %location%  executeTestCases()
%mc% %location%  checkMetamorphisms([PiMinusAssertion])
%mc% %location%  MeasureTestSet([avgDistance])
pause