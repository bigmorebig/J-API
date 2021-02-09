FROM java:8
COPY target/*.jar /app.jar
CMD ["--server-port=8060"]
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "/app.jar"]