@echo off

set CUR_PRJ="%cd%"
cd ..\..\..\scripts
call env.bat
cd /d "%CUR_PRJ%"

java -jar out\libs\Producer-Consumer.jar

pause