#Start with a base image conataining java runtime
FROM openjdk:17-jdk-slim as build

#Information around who maintains the image
MAINTAINER KirtiShekharPandey

#Add the application's jar to the container 
COPY target/MicroservicesBankingConfigurationServerProject-0.0.1-SNAPSHOT.jar MicroservicesBankingConfigurationServerProject-0.0.1-SNAPSHOT.jar

#Excute the application
ENTRYPOINT ["java","-jar","/MicroservicesBankingConfigurationServerProject-0.0.1-SNAPSHOT.jar"]

#Expose Port Number of application
EXPOSE 9924