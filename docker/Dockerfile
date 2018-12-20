FROM openjdk:8u171-jre-alpine3.8
EXPOSE 9009

COPY target/SampleCRUDService-0.0.1-SNAPSHOT.jar /usr/src/myapp/app.jar

#for https
#RUN echo $JAVA_HOME
#COPY DockerCompose/gitlab_certificate.cer /usr/local/share/ca-certificates/gitlab_certificate.cer

#RUN keytool -noprompt -storepass changeit -import -alias mycertificate -keystore $JAVA_HOME/lib/security/cacerts -file /usr/local/share/ca-certificates/gitlab_certificate.cer



WORKDIR /usr/src/myapp
CMD ["java", "-jar", "app.jar"]