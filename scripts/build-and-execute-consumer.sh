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

function runConsumer()
{
    projectName=$1
    cd ../
    cd "$projectName/build/libs"
    artifactName=`ls`
    commandRun="java -jar $artifactName"
    echo "Run: $commandRun"
    $commandRun
    echo "Returning to folder $rootFolderName"
    cd $rootFolderName
}

rootFolderName=$(pwd)
buildFolterName="build/libs/"

consumerProjectName="jms-consumer-demo"

echo "Initializing build..."
echo "Current folder is: $rootFolderName"

buildProject $consumerProjectName

runConsumer $consumerProjectName

