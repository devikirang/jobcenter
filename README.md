# jobcenter


## Setup
* Install JDK 1.8
* Install Spring Boot http://docs.spring.io/spring-boot/docs/current/reference/html/
* Install MongoDB http://docs.mongodb.org/manual/installation/
getting-started-installing-spring-boot.html#getting-started-installing-the-cli
* Install NodeJS 6.9.1
* Install `npm install -g bower`
* Install `npm install -g polymer-cli`
* Run `mvn package` in folder jc-server-app. Any error check for proxy settings for maven.
* Run `bower install` in folder jc-client-app. Any error check for proxy settings for bower, github, npm.

## Starting DB, server app and client app
* Start mangodb with command `mongod`. Runs DB on port - 27017
* Start rest service from folder jc-rest-service with command `mvn spring-boot:run`. Runs Tomcat on port 9090
* Start client web app from folder jc-client-app with command `polymer serve`. Runs Web on port 8080

## Application navigation flow.
* Access application from http://localhost:8080/
* Find the registed users list from the Registeration page.
* Candidate logs in and selects Job from all the jobs. - 'src/java/com.jobcenter.model.Job'
* The Job has Recruiter contact details and Location details.
* Candidate applies for a 'Job' postion with Resume. - 'src/java/com.jobcenter.model.JobApplication'
* Recruiter schedules the interview for the Candidate. - 'src/java/com.jobcenter.model.JobInterview'
* Manager and Interviewers add their interview rate the condidate on his/her skills. Add Comments and notes in - 'src/java/com.jobcenter.model.InterViewSession'
* Manager can see all the JobInterviews for that Job with each candidates Score at Skill level.

## Algorithm for Ranking
* 'src/java/com.jobcenter.model.JobInterview' has method 'getCandidateScore' to calculate the skill score from multiple inteview sessions.
* Higher the score the best candidate for the Job.
