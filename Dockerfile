FROM eclipse-temurin:17-jdk-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19
COPY --from=build /target/brettaApiRest-0.0.1-SNAPSHOT.jar brettaApiRest-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","brettaApiRest-0.0.1-SNAPSHOT.jar"]
