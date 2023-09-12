FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-slim
COPY --from=build /target/EazySchool-0.0.1-SNAPSHOT.jar EazySchool.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","EazySchool.jar"]