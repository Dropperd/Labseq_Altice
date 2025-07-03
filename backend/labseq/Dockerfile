FROM amazoncorretto:21-alpine

COPY target/quarkus-app/ /deployments/

EXPOSE 8080
WORKDIR /deployments
CMD ["java", "-jar", "quarkus-run.jar"]