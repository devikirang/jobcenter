package com.jobcenter;

import com.jobcenter.dao.CandidateJobDao;
import com.jobcenter.dao.JobDao;
import com.jobcenter.dao.UserDao;
import com.jobcenter.model.*;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private CandidateJobDao candidateJobDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Assume all the below data is submitted from UI forms
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        this.registerUsers();
        this.postNewJobsByRecruiter();

        candidateJobDao.deleteAll();
        // Step 1: candidates apply for Job Position.
        logger.info("Data: Applying for Jobs");
        User candidate1 = this.userDao.findByEmail("test.candidate1@gmail.com");
        CandidateJob candidateJob1 = this.applyToJob(candidate1, "JAVA0T");

        User candidate2 = this.userDao.findByEmail("test.candidate2@gmail.com");
        CandidateJob candidateJob2 = this.applyToJob(candidate2, "JAVA0T");

        User candidate3 = this.userDao.findByEmail("test.candidate3@gmail.com");
        CandidateJob candidateJob3 = this.applyToJob(candidate3, "JAVA0T");

        //Step 2: Interview Sessions for Candidates.
        // All candidates are interviewed by two interviewers and manager.
        logger.info("Data: Performing Interviews and rating candidates");
        User interviewer1 = this.userService.findUserByEmail("test.interviewer1@jobcorp.com");
        User interviewer2 = this.userService.findUserByEmail("test.interviewer2@jobcorp.com");
        User manager = this.userDao.findByEmail("test.manager@jobcorp.com");
        this.performInterviewsForCandidate1(candidateJob1, interviewer1, interviewer2, manager);
        this.performInterviewsForCandidate2(candidateJob2, interviewer1, interviewer2, manager);
        this.performInterviewsForCandidate3(candidateJob3, interviewer1, interviewer2, manager);
        logger.info("Data: Data setup is done.");
    }

    private void registerUsers() throws BusinessException {
        logger.info("Data: Registering Users");
        userDao.deleteAll();
        userService.registerUser(new User("test.candidate1@gmail.com", "test", "DeviKiran", Role.INTERVIEWEE));
        userService.registerUser(new User("test.candidate2@gmail.com", "test", "Dhanush", Role.INTERVIEWEE));
        userService.registerUser(new User("test.candidate3@gmail.com", "test", "Krishna", Role.INTERVIEWEE));
        userService.registerUser(new User("test.recruiter@jobcorp.com", "test", "Frank", Role.RECRUITER));
        userService.registerUser(new User("test.manager@jobcorp.com", "test", "John", Role.MANAGER));
        userService.registerUser(new User("test.interviewer1@jobcorp.com", "test", "David", Role.INTERVIWER));
        userService.registerUser(new User("test.interviewer2@jobcorp.com", "test", "Joseph", Role.INTERVIWER));
    }

    private void postNewJobsByRecruiter() {
        logger.info("Data: Posting New Jobs By Recruiter");
        jobDao.deleteAll();
        User recruiter = this.userDao.findByEmail("test.recruiter@jobcorp.com");
        User manager = this.userDao.findByEmail("test.manager@jobcorp.com");
        JobLocation location1 = new JobLocation("2800 main st", "Flower Mound", "75028");
        JobLocation location2 = new JobLocation("120 main st", "Irving", "75038");
        Job job1 = new Job("JAVA0T", "Sr. Developer", "Test Job Description", recruiter, manager, location1);
        job1.setWeighedSkills(new ArrayList(Arrays.asList(
                new WeighedSkill(Skill.JAVA, 5),
                new WeighedSkill(Skill.JAVASCRIPT, 4),
                new WeighedSkill(Skill.BEHAVIOURAL_INTERVIEW, 3),
                new WeighedSkill(Skill.COMMUNICATION, 3),
                new WeighedSkill(Skill.LINUX, 5),
                new WeighedSkill(Skill.DATABASE, 5)
        )));
        jobDao.save(job1);

        Job job2 = new Job("JAVA0G", "Development Manager", "Test Job Description", recruiter, manager, location2);
        job2.setWeighedSkills(new ArrayList(Arrays.asList(
                new WeighedSkill(Skill.JAVA, 5),
                new WeighedSkill(Skill.JAVASCRIPT, 5),
                new WeighedSkill(Skill.BEHAVIOURAL_INTERVIEW, 5),
                new WeighedSkill(Skill.COMMUNICATION, 5),
                new WeighedSkill(Skill.LINUX, 4),
                new WeighedSkill(Skill.DATABASE, 5)
        )));
        jobDao.save(job2);
    }

    private CandidateJob applyToJob(User candidate, String jobCode) {
        CandidateJob candidateJob = new CandidateJob(candidate, jobCode, new Date());
        candidateJob.setResume("My Test Resume .... ..... ....".getBytes());
        return candidateJobDao.save(candidateJob);
    }

    private void performInterviewsForCandidate1(CandidateJob candidateJob1, User interviewer1, User interviewer2, User manager) {
        // Interview Session 1
        InterviewSession session1 = new InterviewSession(interviewer1, candidateJob1.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 5),
                new SkillRating(Skill.JAVASCRIPT, 5),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 5),
                new SkillRating(Skill.COMMUNICATION, 5),
                new SkillRating(Skill.LINUX, 5),
                new SkillRating(Skill.DATABASE, 5)
        )));
        session1.setComments("Good fit for the Job");

        // Interview Session 2
        InterviewSession session2 = new InterviewSession(interviewer2, candidateJob1.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 5),
                new SkillRating(Skill.JAVASCRIPT, 5),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 4),
                new SkillRating(Skill.COMMUNICATION, 4),
                new SkillRating(Skill.LINUX, 4),
                new SkillRating(Skill.DATABASE, 4)
        )));
        session2.setComments("Performed above average");

        // Manager interview
        InterviewSession session3 = new InterviewSession(manager, candidateJob1.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 5),
                new SkillRating(Skill.JAVASCRIPT, 5),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 5),
                new SkillRating(Skill.COMMUNICATION, 5),
                new SkillRating(Skill.LINUX, 5),
                new SkillRating(Skill.DATABASE, 5)
        )));
        candidateJob1.setInterviewSessions(new ArrayList(Arrays.asList(session1, session2, session3)));
        candidateJobDao.save(candidateJob1);
    }

    private void performInterviewsForCandidate2(CandidateJob candidateJob2, User interviewer1, User interviewer2, User manager) {
        // Interview Session 1
        InterviewSession session1 = new InterviewSession(interviewer1, candidateJob2.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 3),
                new SkillRating(Skill.JAVASCRIPT, 3),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 5),
                new SkillRating(Skill.COMMUNICATION, 5),
                new SkillRating(Skill.LINUX, 3),
                new SkillRating(Skill.DATABASE, 2)
        )));
        session1.setComments("Performed good. Not the best");
        // Interview Session 2
        InterviewSession session2 = new InterviewSession(interviewer2, candidateJob2.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 4),
                new SkillRating(Skill.JAVASCRIPT, 3),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 5),
                new SkillRating(Skill.COMMUNICATION, 5),
                new SkillRating(Skill.LINUX, 4),
                new SkillRating(Skill.DATABASE, 3)
        )));
        session2.setComments("Good fit, overall");
        // Manager interview
        InterviewSession session3 = new InterviewSession(manager, candidateJob2.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 3),
                new SkillRating(Skill.JAVASCRIPT, 4),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 4),
                new SkillRating(Skill.COMMUNICATION, 4),
                new SkillRating(Skill.LINUX, 4),
                new SkillRating(Skill.DATABASE, 3)
        )));
        candidateJob2.setInterviewSessions(new ArrayList(Arrays.asList(session1, session2, session3)));
        candidateJobDao.save(candidateJob2);
    }

    private void performInterviewsForCandidate3(CandidateJob candidateJob3, User interviewer1, User interviewer2, User manager) {
        // Interview Session 1
        InterviewSession session1 = new InterviewSession(interviewer1, candidateJob3.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 3),
                new SkillRating(Skill.JAVASCRIPT, 2),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 4),
                new SkillRating(Skill.COMMUNICATION, 4),
                new SkillRating(Skill.LINUX, 4),
                new SkillRating(Skill.DATABASE, 3)
        )));
        session1.setComments("Good in communications. Ok on technical skills.");
        // Interview Session 2
        InterviewSession session2 = new InterviewSession(interviewer2, candidateJob3.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 4),
                new SkillRating(Skill.JAVASCRIPT, 3),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 4),
                new SkillRating(Skill.COMMUNICATION, 4),
                new SkillRating(Skill.LINUX, 3),
                new SkillRating(Skill.DATABASE, 2)
        )));
        session1.setComments("Average Candidate.");

        // Manager interview
        InterviewSession session3 = new InterviewSession(manager, candidateJob3.getCandidate(), new ArrayList(Arrays.asList(
                new SkillRating(Skill.JAVA, 3),
                new SkillRating(Skill.JAVASCRIPT, 3),
                new SkillRating(Skill.BEHAVIOURAL_INTERVIEW, 4),
                new SkillRating(Skill.COMMUNICATION, 4),
                new SkillRating(Skill.LINUX, 3),
                new SkillRating(Skill.DATABASE, 2)
        )));
        candidateJob3.setInterviewSessions(new ArrayList(Arrays.asList(session1, session2, session3)));
        candidateJobDao.save(candidateJob3);
    }
}
