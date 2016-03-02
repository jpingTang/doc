#!/bin/bash
path=`dirname $0`
unzip *.apk classes.dex -d ./diordna/
$path/dex2jar/d2j-dex2jar.sh -f ./diordna/classes.dex -o ./diordna/classes_dex2jar.jar
$path/JD-GUI.app/Contents/MacOS/jd-gui ./diordna/classes_dex2jar.jar
