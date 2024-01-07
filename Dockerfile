FROM openjdk:11

ARG JAR_FILE=target/NegociosLucrativosJWT-1.0-SNAPSHOT.jar
ARG DEPENDENCY=target

COPY ${JAR_FILE} NegociosLucrativosJWT-1.0-SNAPSHOT.jar
COPY ${DEPENDENCY}/lib  /lib


ENTRYPOINT ["java","-jar","/NegociosLucrativosJWT-1.0-SNAPSHOT.jar"]