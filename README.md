# jobcenter


## Setup
* Install JDK 1.8
* Install MongoDB http://docs.mongodb.org/manual/installation/
* Install Spring Boot http://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html#getting-started-installing-the-cli
* Install NodeJS 6.9.1
* install `npm -g bower`
* install `npm -g polymer`

## Startup
* Start mangodb with command `mongod`
** Running on port - 27017
* Start Job center rest service from folder jc-rest-service with command `mvn package && java -jar target/gs-spring-boot-0.1.0.jar`
** Running on port 8080
* Start Polymer web application client from folder jc-client-app with command ``
** Running on port 9080