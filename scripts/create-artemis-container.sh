#!/bin/bash

buildDockerContainerArtemisCommand="sudo docker run -d -p 61616:61616 -p 8161:8161 --name artemis-prod-cons vromero/activemq-artemis:alpine-latest"

echo "Building artemis docker container: $buildDockerContainerArtemisCommand."

$buildDockerContainerArtemisCommand

echo 'Container was built.'

