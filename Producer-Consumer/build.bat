@echo off

REM Сохранения пути папки с проектом
set CUR_PRJ="%cd%"

REM Переход к папке с программами и установка переменных сред
cd ..\..\..\scripts
call env.bat

REM Переход назад к папке с проектом и запуск сборки
cd /d "%CUR_PRJ%"
REM --offline
call gradle build

pause