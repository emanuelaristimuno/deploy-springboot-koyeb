FROM amazoncorretto:11-alpine-jdk
MAINTAINER emaaristimuno
COPY target/portfolio-final-deploy-0.0.1-SNAPSHOT.jar portfolio-final-deploy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolio-final-deploy-0.0.1-SNAPSHOT.jar"] 
