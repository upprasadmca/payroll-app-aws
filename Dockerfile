FROM public.ecr.aws/docker/library/openjdk:17

MAINTAINER umprasad.mca@gmail.com

ARG ENCRYPTOR_PASSWORD=demo

RUN echo "ENCRYPTOR_PASSWORD::$ENCRYPTOR_PASSWORD"

ENV JASYPT_ENCRYPTOR_PASSWORD=$ENCRYPTOR_PASSWORD

RUN echo "JASYPT_ENCRYPTOR_PASSWORD::$JASYPT_ENCRYPTOR_PASSWORD"

WORKDIR /app

COPY ./target/payroll-app-0.0.1-SNAPSHOT.jar /app/payapp.jar

EXPOSE 8080

CMD ["java","-Djasypt.encryptor.password=$ENCRYPTOR_PASSWORD","-jar", "payapp.jar"]
