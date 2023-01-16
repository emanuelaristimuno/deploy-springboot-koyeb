FROM amazoncorretto:11
MAINTAINER emanuelaristi
COPY target/portfolio-final-deploy-0.0.1-SNAPSHOT.jar portfolio-final-deploy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolio-final-deploy-0.0.1-SNAPSHOT.jar"]