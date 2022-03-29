FROM openjdk:8u322-jdk-slim
COPY . .
RUN ./gradlew -Denv=qa sub:on-test