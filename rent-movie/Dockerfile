FROM openjdk:17.0.2-slim
COPY /rent-movie/target/rent-movie-0.0.1-SNAPSHOT.jar rent-movie.jar

COPY /elasticsearch/elastic-apm-agent-1.33.0.jar /elastic/elastic-apm-agent-1.33.0.jar
ENTRYPOINT ["java", "-javaagent:/elastic/elastic-apm-agent-1.33.0.jar","-Delastic.apm.service_name=rent-movie","-Delastic.apm.server_url=http://apm:8200","-Delastic.apm.application_packages=com.example", "-jar", "rent-movie.jar"]