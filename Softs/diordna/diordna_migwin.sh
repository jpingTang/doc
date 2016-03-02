#!/bin/bash
path=`dirname $0`
unzip $1 classes.dex -d ./diordna/
$path/dex2jar/d2j-dex2jar.sh -f ./diordna/classes.dex -o ./diordna/classes_dex2jar.jar
$path/jd-gui.exe ./diordna/classes_dex2jar.jar
