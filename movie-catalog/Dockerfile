FROM openjdk:17.0.2-slim
COPY /movie-catalog/target/movie-catalog-0.0.1-SNAPSHOT.jar movie-catalog.jar

COPY /elasticsearch/elastic-apm-agent-1.33.0.jar /elastic/elastic-apm-agent-1.33.0.jar
ENTRYPOINT ["java", "-javaagent:/elastic/elastic-apm-agent-1.33.0.jar","-Delastic.apm.service_name=movie-catalog","-Delastic.apm.server_url=http://apm:8200","-Delastic.apm.application_packages=com.observability.com", "-jar", "movie-catalog.jar"]
