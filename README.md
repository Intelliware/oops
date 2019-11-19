# OOPS

Explore resiliency with Hysterix, Chaos Monkey, and Gatling.

## Build

./mvn clean install

## Run Normal mode

Run the application chaos free:
```
./mvnw spring-boot:run
```

## Run with Chaos

Enable Chaos Monkey to introduce failures.

```
./mvnw spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=chaos-monkey
```

## Accounts API

Simple Restful API to trigger the server and service calls.

```
curl localhost:8080/accounts

```

## Gatling

Run a default gatling test from the command line.

```
./mvnw gatling:test

```
