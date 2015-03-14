FROM dockerfile/java:oracle-java8
MAINTAINER david.mouser@gmail.com

RUN apt-get update
RUN apt-get upgrade -y

RUN apt-get -y install mysql-server
EXPOSE 3306
CMD ["/usr/bin/mysqld_safe"]

EXPOSE 8080
CMD java -jar player-service.jar
ADD build/player-service.jar /data/player-service.jar
