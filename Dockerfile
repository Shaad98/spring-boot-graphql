FROM maven:3.9.11-eclipse-temurin-25-alpine AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jdk-alpine

WORKDIR /app


COPY --from=builder /app/target/*.jar app.jar

CMD [ "java","-jar","app.jar" ]
