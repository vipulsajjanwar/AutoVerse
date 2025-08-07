@echo off
setlocal enabledelayedexpansion

REM Step 1: Get current directory
set "WIN_DIR=%~dp0"
set "WIN_DIR=%WIN_DIR:~0,-1%"

REM Step 2: Extract drive and build WSL path
set "DRIVE_LETTER=%WIN_DIR:~0,1%"
set "PATH_PART=%WIN_DIR:~2%"
set "PATH_PART=%PATH_PART:\=/%"
set "TEMP_WSL_PATH=/mnt/%DRIVE_LETTER%%PATH_PART%"

REM Step 3: Convert to lowercase using PowerShell
for /f "usebackq delims=" %%i in (`powershell -nologo -command "'%TEMP_WSL_PATH%'.ToLower()"`) do set "WSL_PATH=%%i"

REM Step 4: Debug output
echo.
echo Windows Path: %WIN_DIR%
echo WSL Path: %WSL_PATH%
echo.

REM Step 5: Start WSL to warm up
echo Starting WSL...
wsl echo "WSL initialized."

REM Step 6: Wait for WSL to warm up
timeout /t 3 >nul

REM Step 7: Run docker-compose with two files
wsl bash -c "cd '%WSL_PATH%' && echo 'Running docker-compose file...' && docker-compose -f docker-compose-grid.yaml down && echo 'Docker grid containers stopped.'"

echo.
echo Done.
pause
 