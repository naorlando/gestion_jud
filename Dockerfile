FROM eclipse-temurin:17-jre
ARG JAR_FILE=target/gestion-jud-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
