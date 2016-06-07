7z e *.apk -y *.dex
call dex2jar/dex2jar.bat classes.dex
del classes.dex
call jd-gui classes_dex2jar.jar
pause
