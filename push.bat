@echo off

:: ��¥�� yyyyMMdd �������� ��������
for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value ^| find "="') do set datetime=%%I
set date=%datetime:~0,8%

:: Git ��ɾ� ����
git add *
git commit -m "%date%"
git push origin main

pause
