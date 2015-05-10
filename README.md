# HumanTalks : Microservices

This repository contains the code I used at the May's HumanTalk conference (Lyon).

It contains two services :
* _The Front service_ which redirect and load-balance any request received on `/echo`
* _The Echo service_ which echo any body sent to it (adding its IP adress so one is able to identify which instance answered the request).

To run the system, just type :

	git clone https://github.com/MaximeGaudin/HT-Microservices.git && cd HT-Microservices && mvn clean install && docker-compose up

It will spawn both of the service and a special instance of the echo service that is a bit slower to demonstrate the latency-aware load-balancing. It can be pretty long depending on how many maven repositories you already pulled and how many docker base image are cached on your machine.

## Why is it so slow to start ?

Because of the architecture, each instance has to register to the service registry (Eureka). By design, it could take at most 3 heartbeats (a heartbeat is sent every 3 secondes) to register an instance. Added to the service startup time, one may wait a full minute before the API is available. For more information, please see [here](http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html#_why_is_it_so_slow_to_register_a_service).

## Can I scale the echo service up ?

Yes : `docker-compose scale echo=3` for 3 instances.

### Weird, when I scale down, every containers shut down

[Bug report here.](https://github.com/docker/compose/issues/1107)

## The speaker service

Because @jdray is speaker right after me, I added a dummy endpoint which send the list of every 2015 HT speaks.
To request it, run the system and perform the following request : `GET http://localhost:8081/echo/speakers`

For instance :

	docker-compose up -d && until $(curl --output /dev/null --silent --head --fail http://localhost:8081/echo/speakers); do; printf '.'; sleep 1; done && curl -XGET 'http://localhost:8081/echo/speakers'

## Requirements

* Docker >= 1.5 : `wget -qO- https://get.docker.com/ | sh`
* Docker-compose : `sudo pip install docker-compose`
* Maven >= 3.0
* Java 8
