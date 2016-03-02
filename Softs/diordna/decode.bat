rem jad -o -f -r -sjava -dsrc decode/**/**/*.class
rem jad -o -f -r -sjava -dsrc decode/**/*.class
rem jad -o -f -r -sjava -dsrc decode/*.class
rem jad -o -r -sjava -dsrc decode/b*.class
rem jad -o -r -sjava -dsrc decode/ns.class
rem for %%i in (./decode/*.class) do (@echo %%i jad -o -r -sjava -dsrc decode/%%i)
for /r ./decode/ %%i in (*.class) do (@echo %%i 
set "tttmp=%%i"
set "tttmp=%tttmp:/=\%"
echo %tttmp%
)
pause