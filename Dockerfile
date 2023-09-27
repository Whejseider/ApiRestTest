#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/brettaApiRest-0.0.1-SNAPSHOT.jar brettaApiRest-0.0.1-SNAPSHOT.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","brettaApiRest-0.0.1-SNAPSHOT.jar"]