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

## Application Domain.
* Access application from http://localhost:8080/login
* Find the registed users list from the Rigister page. - 'src/java/com.jobcenter.model.User'
* Candidate logs in and selects Job from all the jobs. - 'src/java/com.jobcenter.model.Job'
* The Job has Recruiter contact details and Location details. - 'src/java/com.jobcenter.model.Job'
* Candidate applies for a 'Job' postion with Resume. - 'src/java/com.jobcenter.model.CandidateJob'
* Manager and Interviewers add their rating on his/her skills and comments.- 'src/java/com.jobcenter.model.InterviewSession'

## Data 
For time being all the Data is created in 'src/java/com.jobcenter.Application'. 
Assume this data is submitted using UI froms by recruiter, interviewer and interviewee.

## User Role
* INTERVIEWEE - has access to 'All Jobs', 'My Applied Jobs'
* RECURITER - has access to 'All Jobs', 'Post New Job'
* INTERVIWER - has access to 'All Jobs', 'My Interviews'
* MANAGER - has access to 'All Jobs', 'My Interviews' and 'Interview Results'

## Algorithm for Skill Ranking or Candidate Score
* 'src/java/com.jobcenter.service.impl.CandidateJobServiceImpl' has method 'calculateCandidateScore' to calculate the skill score from multiple inteview sessions.
* Higher the score the best candidate for the Job.
* Login as MANAGER and check 'Interview Results' page for Score and Rank.
