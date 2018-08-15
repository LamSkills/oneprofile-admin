#!/usr/bin/env sh


CP_PARAM="-cp ./target/oneprofile-admin-demo-kickstart-1.0.0-SNAPSHOT.jar"
DEBUG_PARAM="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5003"
LAUNCHER_CLASS="org.springframework.boot.loader.JarLauncher"

JAVA_CMD="java $CP_PARAM $DEBUG_PARAM $LAUNCHER_CLASS"

 $JAVA_CMD
