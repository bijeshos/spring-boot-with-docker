FROM openjdk:8-jre-alpine
WORKDIR /apps
COPY target/spring-boot-with-docker-demo-0.1.jar /apps
EXPOSE 9090
LABEL MAINTAINER="bijeshos.github.io"
LABEL VERSION="0.1-alpha"
CMD ["java","-jar","spring-boot-with-docker-demo-0.1.jar"]
