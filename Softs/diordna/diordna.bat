REM path=%~dp0
REM 7z e %1 -y *.dex -odiordna
REM call %path%dex2jar\d2j-dex2jar.bat -f .\diordna\classes.dex -o .\diordna\classes_dex2jar.jar
REM call %path%jd-gui.exe .\diordna\classes_dex2jar.jar

7z e *.apk -y *.dex
call dex2jar/dex2jar.bat classes.dex
del classes.dex
call jd-gui classes_dex2jar.jar
