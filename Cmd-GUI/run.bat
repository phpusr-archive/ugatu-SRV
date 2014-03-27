@echo off

set CUR_PRJ="%cd%"
cd ..\..\..\scripts
call env.bat
cd /d "%CUR_PRJ%"

REM java -jar build\classes\artifacts\Cmd_GUI_jar\Cmd-GUI.jar
java -jar build\libs\Cmd-GUI.jar

pause