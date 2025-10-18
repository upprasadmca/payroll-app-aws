FROM public.ecr.aws/docker/library/openjdk:17

MAINTAINER umprasad.mca@gmail.com

ENV JASYPT_ENCRYPTOR_PASSWORD=myaws

WORKDIR /app

COPY ./target/payroll-app-0.0.1-SNAPSHOT.jar /app/payapp.jar

EXPOSE 8080

CMD ["java","-jar","payapp.jar"]