#!/usr/bin/env sh


CP_PARAM="-cp ../oneprofile-admin/target/oneprofile-admin-fat-exec.jar"
DEBUG_PARAM="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5001"
LAUNCHER_CLASS="org.springframework.boot.loader.JarLauncher"

JAVA_CMD="java $CP_PARAM $DEBUG_PARAM $LAUNCHER_CLASS"

 $JAVA_CMD
