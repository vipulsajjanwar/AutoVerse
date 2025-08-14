@echo off
setlocal enabledelayedexpansion

:: Enable color output
for /f %%a in ('powershell -command "$host.UI.RawUI.ForegroundColor"') do set COLOR_DEFAULT=%%a

:: ========== Fancy Logging Functions ==========
set "LOG_INFO=[36m[INFO][0m"
set "LOG_WARN=[33m[WARN][0m"
set "LOG_ERR=[31m[ERROR][0m"
set "LOG_OK=[32m[ OK ][0m"

echo [95m============================================================[0m
echo [96m          __    ______   _____    ______     _______        [0m
echo [96m         /  /  /  ___/  /  __/   /  __  \   /  __   \       [0m
echo [96m        /  /  /  /     /  /__   /  / /  /  /  /  /  /       [0m
echo [96m       /  /  /  /     /  ___/  /  / /  /  /  /__/  /        [0m
echo [96m      /  /  /  /___  /  /__   /  /_/  /  /_____   /         [0m
echo [96m     /__/  /______/ /_____/  /______/        \__\          [0m
echo.
echo       [3m[92m  SELENIUM GRID   [0m
echo.
echo [95m============================================================[0m
echo.

:: Step 1: Get current Windows directory
set "WIN_DIR=%~dp0"
set "WIN_DIR=%WIN_DIR:~0,-1%"

:: Step 2: Build WSL-compatible path
set "DRIVE_LETTER=%WIN_DIR:~0,1%"
set "PATH_PART=%WIN_DIR:~2%"
set "PATH_PART=%PATH_PART:\=/%"
set "TEMP_WSL_PATH=/mnt/%DRIVE_LETTER%%PATH_PART%"

:: Step 3: Convert to lowercase for Linux
for /f "usebackq delims=" %%i in (`powershell -nologo -command "'%TEMP_WSL_PATH%'.ToLower()"`) do set "WSL_PATH=%%i"

:: Display paths
echo %LOG_INFO% Windows Path: %WIN_DIR%
echo %LOG_INFO% WSL Path:     %WSL_PATH%
echo.

:: Step 4: Start WSL
echo %LOG_INFO% Initializing WSL environment...
wsl echo "WSL Initialized."

:: Wait for WSL to be ready
timeout /t 2 >nul

:: Step 5: Initialize Swarm & Deploy Stack
echo %LOG_INFO% Initializing Docker Swarm...
wsl bash -c "cd '%WSL_PATH%' && docker swarm init --advertise-addr $(hostname -I | awk '{print $1}') || true"

echo %LOG_INFO% Deploying Selenium Grid Stack...
wsl bash -c "cd '%WSL_PATH%' && docker stack deploy -c docker-compose-grid-swarm.yaml sel"

:: Step 6: Wait until all services are running
echo %LOG_INFO% Waiting for all replicas to be up...
:WAIT_SERVICES
for /f "tokens=*" %%i in ('wsl bash -c "docker service ls --format \"{{.Replicas}}\""') do (
    set "replicas=%%i"
    for /f "tokens=1,2 delims=/" %%a in ("!replicas!") do (
        if NOT "%%a"=="%%b" (
            timeout /t 3 >nul
            goto WAIT_SERVICES
        )
    )
)

echo %LOG_OK% All services are running with desired replicas!

:: Final message
echo.
echo [95m================================================[0m
echo      [97m Dockerised Selenium Grid is UP & READY [0m
echo [95m================================================[0m
echo.
pause
