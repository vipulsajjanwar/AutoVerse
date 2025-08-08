# Use Alpine as the base image
FROM alpine:latest AS build

# Install OpenJDK 17, Maven, and required utilities
RUN apk update && \
    apk add --no-cache openjdk17 maven wget unzip bash

# Set environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV PATH=$JAVA_HOME/bin:$PATH

RUN mkdir /app

# Set the working directory inside the container
WORKDIR /app
 
# Copy Maven project files into the container
COPY pom.xml ./
COPY src ./src
COPY testSuites ./testSuites 
COPY reports ./reports
COPY test-output ./test-output
COPY target ./target
COPY lib ./lib

RUN mvn -v 

RUN java -version

# Package the application
RUN mvn clean install -DskipTests=true

# Install wget and unzip for downloading and extracting chromedriver
RUN apk add --no-cache wget unzip

