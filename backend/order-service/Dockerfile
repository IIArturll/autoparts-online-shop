FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests=true;

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/order-service-0.0.1-SNAPSHOT.jar /order.jar
WORKDIR /
ENTRYPOINT ["java", "-jar", "order.jar"]