FROM openjdk:11
COPY target/oscar-server-1.0-SNAPSHOT.jar oscar-server-1.0-SNAPSHOT.jar

COPY oscar-service.jks oscar-service.jks
COPY movie-service.crt movie-service.crt

USER root
RUN keytool -importcert -keystore $JAVA_HOME/lib/security/cacerts -storepass changeit -alias oscar-service -trustcacerts -file movie-service.crt -noprompt

ENTRYPOINT ["java", "-jar", "oscar-server-1.0-SNAPSHOT.jar"]