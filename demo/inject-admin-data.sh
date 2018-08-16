#!/usr/bin/env sh


CP_PARAM="-cp ./oneprofile-admin-data-injection/target/oneprofile-admin-data-injection-fat-exec.jar"
DEBUG_PARAM="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5003"
LAUNCHER_CLASS="org.springframework.boot.loader.JarLauncher"
ARGS="-Ddata.path=oneprofile-admin-data-injection/src/main/resources/data"

JAVA_CMD="java $CP_PARAM $DEBUG_PARAM $ARGS $LAUNCHER_CLASS"

 $JAVA_CMD
