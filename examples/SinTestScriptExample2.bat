@echo off
cd C:\Morphy
set mc=java -jar MorphyCloud.jar 
set location1=-remote@161.73.158.226
set location2=-remote@161.73.158.222
%mc% %location1% playTestScript(C:\Morphy\SinTestScript.txt)
%mc% %location2% playTestScript(C:\Morphy\SinTestScript.txt)
pause