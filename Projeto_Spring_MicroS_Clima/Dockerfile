FROM maven:3.9.15-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml /app/
RUN mvn dependency:go-offline

COPY . /app/
RUN mvn clean install -DskipTests

FROM eclipse-temurin:21.0.11_10-jre-alpine-3.23

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java","-jar","app.jar" ]