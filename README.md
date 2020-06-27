## Project example for work with jms-producers, jms- consumers and publishers and subscribers.

#### These two projects in sub dirs jms-consumer-demo and jms-producer-demo was based in Getting started project of spring-boot.

#### Purpose.

These projects have purpose show how to create a structure of services where a backend service send a message and one of the batch services receives that message and then it processes and broadcast messages for all backend services.

#### Technologies.

- Spring-boot as framework
- Jms (java message service)
- Gradle 6.0.1 (You should use Gradle wrapper to build projects, it is configured in these projects) 
- ActiveMQ to manage queues and topics 
- curl to send messages for jms-producer-demo via http protocol

Obs: Each command should be run in a especific terminal.

#### Requisites

- Java 10+
- docker(all was tested in 19.03.12 version).

#### Scripts.

All scripts are located in sub folder scripts.

#### How to build and run backend(producer) services.

Run script build-and-execute-producer.sh

#### How to build and run batch(consumer) services.

Run script build-and-execute-consumer.sh

#### How to create a artemis service using docker. It should be create once time.

Run script create-artemis-container.sh . This script should be ran once time and you need call 'sudo docker start artemis-prod-cons' every time you restart your machine or check docker docs for configure that container as you want.

#### How to run docker container artemis.

Run sudo docker start artemis-prod-cons

#### How to send a messa for processes.

curl -X GET http://localhost:8080/api/test-controller/send-message

Obs: You can run how many producers and consumers you want, but port of producers should be differente.