FROM java:8
ADD /build/libs/stockapi-0.0.1-SNAPSHOT.jar stockapi.jar
EXPOSE 8080
CMD ["java", "-jar", "stockapi.jar"]
