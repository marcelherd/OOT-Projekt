@echo off
cd ..\Source\oot
call mvn package
copy gui\target\gui-0.0.1-jar-with-dependencies.jar ..\..\bin\WerWirdMillionaer.jar >NUL
cd ..\..\bin