#!/usr/bin/env bash

##Build application
mvn clean install -DskipTests


##Stop docker containers
docker-compose -f ./docker/docker-compose.yml kill

##Remove previous docker containers
docker rm -f docker_spring_1 docker_db_1

##Delete docker images
docker rmi -f postgres userservice-springboot

##Build docker image
docker build . -t "userservice-springboot" -f ./docker/Dockerfile

##Deploy containers
docker-compose -f ./docker/docker-compose.yml up -d