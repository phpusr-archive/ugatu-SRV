@echo off

set CUR_PRJ="%cd%"
cd ..\..\..\scripts
call env.bat
cd /d "%CUR_PRJ%"

java -jar build\classes\artifacts\Cmd_GUI_jar\Cmd-GUI.jar

pause