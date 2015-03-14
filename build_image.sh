#!/bin/sh
mvn clean install -DskipTests
rm -fr build
mkdir build

cp target/*.jar build/player-service.jar
docker build -t player-service .
