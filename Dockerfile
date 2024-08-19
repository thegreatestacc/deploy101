FROM openjdk:22-jdk
ARG JAR_FILE=target/spring_boot_deploy_101.jar
WORKDIR /opt/app
COPY ${JAR_FILE} my-app.jar
ENTRYPOINT ["java","-jar","my-app.jar"]