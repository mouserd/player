#!/bin/sh
docker stop player-service-db
docker rm player-service-db

echo Starting MySQL...
docker run \
  -p 3306:3306 \
  --name player-service-db \
  -e MYSQL_ROOT_PASSWORD=somesecretpassword \
  -e MYSQL_USER=player-service \
  -e MYSQL_PASSWORD=abc123 \
  -e MYSQL_DATABASE=player-service \
  -d mysql

docker stop player-service
docker rm player-service

echo Starting Spring Boot App...
docker run \
  -p 8080:8080 \
  --name player-service \
  --link player-service-db:mysql \
  -e PORT=8080 \
  -e CONFIG_URI=http://192.168.59.103:8888 \
  -e EUREKA_URI=http://192.168.59.103:8761/eureka/ \
  -e DATASOURCE_URL=jdbc:mysql://192.168.59.103:3306/player-service \
  -d player-service
