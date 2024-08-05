FROM openjdk:17-jdk-slim
ENV LANG=C.UTF-8
WORKDIR /home/files/
COPY target/items-1.0-SNAPSHOT.jar app.jar
COPY wait-for-it.sh .
RUN chmod +x wait-for-it.sh

