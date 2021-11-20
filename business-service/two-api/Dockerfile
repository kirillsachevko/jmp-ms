FROM adoptopenjdk/openjdk11:debian-jre

RUN apt-get -q update && apt-get -qy install netcat

WORKDIR /two-api

COPY /target/two-api-*.jar two-api.jar

ADD https://raw.githubusercontent.com/eficode/wait-for/v2.1.0/wait-for wait-for

RUN chmod +x wait-for

CMD ["java", "-jar", "two-api.jar"]