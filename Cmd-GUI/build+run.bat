@echo off

set CUR_PRJ="%cd%"
cd ..\..\..\scripts
call env.bat
cd /d "%CUR_PRJ%"

call gradle run

pause