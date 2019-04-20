FROM java:8
ADD /target/*.jar stockapi.jar
EXPOSE 8080
CMD ["java", "-jar", "stockapi.jar"]
