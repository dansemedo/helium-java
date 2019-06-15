# ----- Base Java ----
FROM maven:3.6.1-jdk-8-alpine AS base
WORKDIR /app
#COPY scripts ./scripts
COPY . .

#
# ---- Dependencies ----
FROM base AS dependencies
RUN mvn clean package

#
# ---- Test ----
FROM dependencies AS test
RUN mvn test


#
# ---- Release ----
FROM  openjdk:8-jre-alpine AS release
WORKDIR /app
# Create a user
RUN adduser -S appuser
USER appuser
COPY --from=dependencies /app/target/helium-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD java -jar app.jar

#
# ---- Integration Test ----
# run integration tests


#Run this cmd to test locally: docker build --target=release -t javaheliumacr.azurecr.io/helium:canary .


