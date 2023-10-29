FROM amazoncorretto:17-alpine
VOLUME /tmp
RUN apk add --no-cache bash # wait-for: Alpine Linux
COPY ./wait-for.sh /
WORKDIR /
RUN chmod +x ./wait-for.sh
ADD ./target/ti9-workspace-api-0.0.1-SNAPSHOT.jar ti9-workspace-api.jar
ENTRYPOINT ["java", "-jar", "/ti9-workspace-api.jar"]