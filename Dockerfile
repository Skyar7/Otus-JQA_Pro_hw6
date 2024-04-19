FROM maven:3-eclipse-temurin-17

USER root

RUN mkdir -p /home/ubuntu/mobile_tests

WORKDIR /home/ubuntu/mobile_tests

COPY . /home/ubuntu/mobile_tests

ENTRYPOINT ["/bin/bash", "entrypoint.sh"]