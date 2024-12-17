FROM quay.io/wildfly/wildfly:33.0.2.Final-jdk21

COPY deployment/module.xml /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/
COPY deployment/postgresql-42.7.4.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/
COPY deployment/standalone.xml /opt/jboss/wildfly/standalone/configuration/

COPY deployment/movie-service.jks /opt/jboss/wildfly/standalone/configuration/
COPY deployment/movie-service.crt movie-service.crt

USER root
RUN keytool -importcert -keystore $JAVA_HOME/lib/security/cacerts -storepass admin_pass -alias movie-service -trustcacerts -file movie-service.crt -noprompt
USER jboss

COPY movie-ejb/build/libs/movie-ejb-1.0-SNAPSHOT.jar /opt/jboss/wildfly/standalone/deployments/
COPY movie-web/build/libs/movie-web-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/