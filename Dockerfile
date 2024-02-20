FROM openjdk:17-jdk

WORKDIR /app

COPY target/tindzava-0.0.1-SNAPSHOT.jar /app/tindzava.jar

EXPOSE 8080

CMD ["java", "-jar", "tindzava.jar"]
#ENTRYPOINT ["top", "-b"]