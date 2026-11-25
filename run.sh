#!/bin/bash
cd /workspaces/OOAD
export DISPLAY=:1
JFX=$HOME/javafx-sdk/lib
rm -rf out
javac --module-path $JFX --add-modules javafx.controls -cp "sqlite-jdbc.jar" -d out $(find . -name "*.java" ! -name IntegrationTest.java) && \
java -Dprism.order=sw --module-path $JFX --add-modules javafx.controls -cp "out:sqlite-jdbc.jar" Main
