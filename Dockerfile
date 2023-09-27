#
# Build stage
#
FROM eclipse-temurin:17-alpine AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM eclipse-temurin:17-alpine
COPY --from=build /target/brettaApiRest-0.0.1-SNAPSHOT.jar brettaApiRest-0.0.1-SNAPSHOT.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","brettaApiRest-0.0.1-SNAPSHOT.jar"]