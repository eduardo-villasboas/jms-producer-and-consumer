#!/bin/bash

function buildProject()
{
    
    projectName=$1

    cd ../
    echo "Entering in: $projectName"

    cd $projectName

    echo "Building $projectName"

   ./gradlew clean build

    echo "Built $(ls $buildFolterName)"

    echo "Returning to folter $rootFolderName"

    cd $rootFolderName

}

function runProducer()
{
    projectName=$1
    port=$2
    cd ../
    cd "$projectName/build/libs"
    artifactName=`ls`
    commandRun="java -jar -Dserver.port=$port $artifactName"
    echo "Run: $commandRun"
    $commandRun
    echo "Returning to folder $rootFolderName"
    cd $rootFolderName
}

rootFolderName=$(pwd)
buildFolterName="build/libs/"

producerProjectName="jms-producer-demo"
port=$1

if [ -z "$1" ]; then
   echo "Please, inform port to run server."
   exit 1
fi

echo "Initializing build..."
echo "Current folder is: $rootFolderName"
buildProject $producerProjectName

runProducer $producerProjectName $port

