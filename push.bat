@echo off

:: 날짜를 yyyyMMdd 형식으로 가져오기
for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value ^| find "="') do set datetime=%%I
set date=%datetime:~0,8%

:: Git 명령어 실행
git add *
git commit -m "%date%"
git push origin main

pause
