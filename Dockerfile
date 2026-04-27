FROM eclipse-temurin:11-jre
COPY target/employees-demo*.jar /usr/src/employees-demo.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/employees-demo.jar", "--spring.config.location=file:/opt/conf/application.properties"]
