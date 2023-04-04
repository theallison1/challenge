FROM amazoncorretto:11-alpine-jdk
COPY "./target/challengeSupervielle-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]