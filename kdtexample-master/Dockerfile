FROM openjdk:8-jdk-alpine
EXPOSE 8081
COPY ./build/libs/kdtexample-1.0.jar grader-docker.jar
ENTRYPOINT ["java","-jar","grader-docker.jar"]