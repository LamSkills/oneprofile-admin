#!/usr/bin/env sh


#cd /demo


CP_PARAM="-cp ../../../oneprofile-admin-data-injection/target/oneprofile-admin-data-injection-fat-exec.jar"
CP_PARAM="$CP_PARAM:."
DEBUG_PARAM="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5001"
LAUNCHER_CLASS="org.springframework.boot.loader.JarLauncher"

JAVA_CMD="java $DEBUG_PARAM $CP_PARAM $LAUNCHER_CLASS $SPRING_PARAM $DATA_PATH"

 $JAVA_CMD
