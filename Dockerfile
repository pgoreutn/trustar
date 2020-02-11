FROM java

VOLUME /tmp

ADD build/libs/interview.jar interview.jar

RUN bash -c 'touch /interview.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/interview.jar"]