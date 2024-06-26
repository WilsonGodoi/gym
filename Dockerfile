FROM registry.access.redhat.com/ubi8/openjdk-17:1.19

ARG BUILD_DIR=./target

WORKDIR /home

COPY ./target/gym-1.0.0.jar .