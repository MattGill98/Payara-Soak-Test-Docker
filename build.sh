#!/bin/sh

mvn clean package -f soak-test-app/pom.xml
cp soak-test-app/target/soak-test-app-1.0-SNAPSHOT.war payara/soak-test.war

docker build -t mattgill98/soak-test-mariadb mariadb/
docker build -t mattgill98/soak-test-jmeter jmeter/
docker build -t mattgill98/soak-test-payara payara/
docker rmi $(docker images -aq -f "dangling=true")
