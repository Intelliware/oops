# OOPS

Explore resiliency with Hystrix, Chaos Monkey, and Gatling.

Architecture:
- Server - Entry server with an `/accounts` restful endpoint.
- Core - Core services with restful endpoints supporting accounts: currentBalance, overnightBalance, and location address.

## Build and Run

./mvnw clean install

### Start Core Services
```
cd core && ./mvnw spring-boot:run && cd ..

curl localhost:8081/address/1234
```
### Start Server

``` 
cd server && ./mvnw spring-boot:run && cd ..

curl localhost:8080/accounts
```
## Run Core with Chaos

Enable Chaos Monkey to introduce failures by activating the `chaos-monkey` profile and one of the specified chaos levels.

Stop the core service if currently running.

```
cd core && ./mvnw spring-boot:run -Dspring-boot.run.profiles=chaos-monkey,chaos-medium && cd ..
```
Level Options:
- `chaos_delays`
- `chaos_medium`
- `chaos_total`

## View Hystrix

View the Hystrix dashboard by opening the following in a web browser:

http://localhost:8080/hystrix/monitor?stream=http://localhost:8080/actuator/hystrix.stream&title=oops

Configure the Core to produce provide some errors timeout requests:

``` 
cd core && ./mvnw spring-boot:run -Dspring-boot.run.profiles=chaos-monkey,chaos-medium && cd ..
```

Run a default gatling test from the command line.

```
./mvnw gatling:test

```

As the gatling test is running you should see the Hystrix dashboard being updated.

## Server Management Endpoints

Enabled by metrics profile.
``` 
cd server && ./mvnw spring-boot:run -Dspring-boot.run.profiles=metrics && cd ..
```

General:

- localhost:8080/actuator/health
- localhost:8080/actuator/info

Chaos Monkey:

- localhost:8080/actuator/chaosmonkey
- localhost:8080/actuator/chaosmonkey/status

Hystrix:

- localhost:8080/actuator/hystrix.stream

## Gatling Results for Chaos Levels

A number of chaos levels have been specified as spring profiles.

### No Chaos

-Dspring-boot.run.profiles=

``` 
================================================================================
---- Global Information --------------------------------------------------------
> request count                                       2700 (OK=2700   KO=0     )
> min response time                                      2 (OK=2      KO=-     )
> max response time                                    221 (OK=221    KO=-     )
> mean response time                                     6 (OK=6      KO=-     )
> std deviation                                          8 (OK=8      KO=-     )
> response time 50th percentile                          5 (OK=5      KO=-     )
> response time 75th percentile                          5 (OK=5      KO=-     )
> response time 95th percentile                          8 (OK=8      KO=-     )
> response time 99th percentile                         37 (OK=37     KO=-     )
> mean requests/sec                                     60 (OK=60     KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                          2700 (100%)
> 800 ms < t < 1200 ms                                   0 (  0%)
> t > 1200 ms                                            0 (  0%)
> failed                                                 0 (  0%)
================================================================================
```
### Delays Only

-Dspring-boot.run.profiles=chaos-monkey,chaos-delays

``` 
================================================================================
---- Global Information --------------------------------------------------------
> request count                                       2700 (OK=2700   KO=0     )
> min response time                                      3 (OK=3      KO=-     )
> max response time                                   2995 (OK=2995   KO=-     )
> mean response time                                   112 (OK=112    KO=-     )
> std deviation                                        469 (OK=469    KO=-     )
> response time 50th percentile                          5 (OK=5      KO=-     )
> response time 75th percentile                          6 (OK=6      KO=-     )
> response time 95th percentile                       1067 (OK=1067   KO=-     )
> response time 99th percentile                       2597 (OK=2597   KO=-     )
> mean requests/sec                                  56.25 (OK=56.25  KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                          2560 ( 95%)
> 800 ms < t < 1200 ms                                  13 (  0%)
> t > 1200 ms                                          127 (  5%)
> failed                                                 0 (  0%)
================================================================================
```

### Medium Chaos

-Dspring-boot.run.profiles=chaos-monkey,chaos-medium

```
================================================================================
---- Global Information --------------------------------------------------------
> request count                                       2700 (OK=2426   KO=274   )
> min response time                                      3 (OK=3      KO=7     )
> max response time                                   2991 (OK=2991   KO=213   )
> mean response time                                   241 (OK=266    KO=16    )
> std deviation                                        675 (OK=708    KO=22    )
> response time 50th percentile                          6 (OK=5      KO=12    )
> response time 75th percentile                          9 (OK=7      KO=14    )
> response time 95th percentile                       2195 (OK=2271   KO=22    )
> response time 99th percentile                       2835 (OK=2853   KO=144   )
> mean requests/sec                                  56.25 (OK=50.542 KO=5.708 )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                          2115 ( 78%)
> 800 ms < t < 1200 ms                                  25 (  1%)
> t > 1200 ms                                          286 ( 11%)
> failed                                               274 ( 10%)
---- Errors --------------------------------------------------------------------
> status.find.in(200,201,202,203,204,205,206,207,208,209,304), f    274 (100.0%)
ound 500
================================================================================
```