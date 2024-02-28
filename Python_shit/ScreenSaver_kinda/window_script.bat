@echo off
:loop
C:\Users\Utente\AppData\Local\Microsoft\WinGet\Packages\NirSoft.NirCmd_Microsoft.Winget.Source_8wekyb3d8bbwe\nircmd.exe closeprocess Python.exe
timeout /nobreak /t 1 >null
goto loop