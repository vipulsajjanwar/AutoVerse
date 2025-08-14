@echo off
setlocal enabledelayedexpansion
:: Enable color output
for /f %%a in ('powershell -command "$host.UI.RawUI.ForegroundColor"') do set COLOR_DEFAULT=%%a

:: ========== Fancy Logging Functions ==========
set "LOG_INFO=[36m[INFO][0m"
set "LOG_WARN=[33m[WARN][0m"
set "LOG_ERR=[31m[ERROR][0m"
set "LOG_OK=[32m[ OK ][0m"

:: ========== Intro ==========
echo [95m================================================[0m
echo    [96mNextGEN Test Automation Execution Script[0m 
echo [95m================================================[0m

:: ========== .env File Check ==========
if not exist ".env" (
    echo %LOG_ERR% .env file not found in current directory.
    pause
    exit /b
)
echo %LOG_OK% .env file found. Loading environment variables...

:: ========== Load .env ==========
for /f "tokens=1,* delims==" %%i in (.env) do (
    set "%%i=%%j"
)

:: ========== Validate Env Variables ==========
if "%IMAGE_NAME%"=="" (
    echo %LOG_ERR% IMAGE_NAME not set in .env
    pause
    exit /b
)

if "%IMAGE_TAG%"=="" (
    echo %LOG_ERR% IMAGE_TAG not set in .env
    pause
    exit /b
)

:: ========== Choose Test Type ==========
echo.
echo [93m Select test suite type:[0m
echo   [1] Sanity
echo   [2] Regression
echo   [3] UAT
echo   [4] Default
set /p TEST_TYPE=Enter choice [1/2/3/4]: 

if "%TEST_TYPE%"=="1" (
    set COMPOSE_FILE=docker-compose-sanity.yaml
) else if "%TEST_TYPE%"=="2" (
    set COMPOSE_FILE=docker-compose-regression.yaml
) else if "%TEST_TYPE%"=="3" (
    set COMPOSE_FILE=docker-compose-uat.yaml
) else if "%TEST_TYPE%"=="4" (
    set COMPOSE_FILE=docker-compose.yaml
) else (
    echo %LOG_ERR% Invalid input. Exiting.
    pause
    exit /b
)
echo %LOG_OK% Selected: %COMPOSE_FILE%

:: ========== Convert Path to WSL Format ==========
set "WIN_DIR=%~dp0"
set "WIN_DIR=%WIN_DIR:~0,-1%"
set "DRIVE_LETTER=%WIN_DIR:~0,1%"
set "PATH_PART=%WIN_DIR:~2%"
set "PATH_PART=%PATH_PART:\=/%"
set "TEMP_WSL_PATH=/mnt/%DRIVE_LETTER%%PATH_PART%"

for /f "usebackq delims=" %%i in (`powershell -nologo -command "'%TEMP_WSL_PATH%'.ToLower()"`) do set "WSL_PATH=%%i"

:: ========== Start WSL ==========
echo.
echo %LOG_INFO% Initializing WSL...
wsl echo "WSL ready"
timeout /t 2 >nul


:: ========== Check Docker Image ==========
echo.
echo %LOG_INFO% Checking Docker image: %IMAGE_NAME%:%IMAGE_TAG%...
wsl docker image inspect %IMAGE_NAME%:%IMAGE_TAG% >nul 2>&1

if %ERRORLEVEL% NEQ 0 (
    echo %LOG_WARN% Image not found. Building now...
    wsl bash -c "cd '%WSL_PATH%' && docker-compose -f %COMPOSE_FILE% build"
) else (
    echo %LOG_OK% Docker image already exists.
)

:: ========== Optional Container Cleanup ==========
echo.
set /p CONTAINER_NAME=Enter container name to clean (leave blank to skip): 
if not "%CONTAINER_NAME%"=="" (
    echo %LOG_WARN% Removing container: %CONTAINER_NAME%...
    wsl docker rm -f %CONTAINER_NAME% >nul 2>&1
)

:: ========== Run Tests ==========
echo.
echo %LOG_INFO% Starting test execution using: %COMPOSE_FILE%
wsl bash -c "cd '%WSL_PATH%' && docker-compose -f %COMPOSE_FILE% up"

echo.
echo [92m Test execution complete! [0m
pause
