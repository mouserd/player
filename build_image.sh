#!/bin/sh
mvn clean install -DskipTests -s ~/.m2/settings-no-nexus.xml
rm -fr build/*

cp target/player-microservice.jar build/
docker build -t player-service .
