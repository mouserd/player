FROM aflmedia/debian-jre8:latest
MAINTAINER david.mouser@gmail.com

EXPOSE 8080
ADD build/player-microservice.jar /data/player-microservice.jar
CMD java -jar /data/player-microservice.jar
