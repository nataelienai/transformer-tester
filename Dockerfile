FROM eclipse-temurin:11-jdk as build
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
RUN ./mvnw package

FROM eclipse-temurin:11-jre
EXPOSE 8080
COPY --from=build /app/target/transformer-tester-*.jar /transformer-tester.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/transformer-tester.jar"]
