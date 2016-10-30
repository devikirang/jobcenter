package com.jobcenter;

import com.jobcenter.dao.JobDao;
import com.jobcenter.dao.UserDao;
import com.jobcenter.model.Role;
import com.jobcenter.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private JobDao jobDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.createUserData();
    }

    private void createUserData() {
        logger.info("Performing create User Data");
        userDao.deleteAll();
        userDao.save(new User("test.cadidate1@gmail.com", "test", "Devi Kiran", Role.INTERVIEWEE));
        userDao.save(new User("test.cadidate2@gmail.com", "test", "Dean", Role.INTERVIEWEE));
        userDao.save(new User("test.cadidate3@gmail.com", "test", "Krishna", Role.INTERVIEWEE));
        userDao.save(new User("test.recruiter@jobcorp.com", "test", "Frank Recruiter", Role.RECURITER));
        userDao.save(new User("test.manager@jobcorp.com", "test", "John Manager", Role.INTERVIWER));
        userDao.save(new User("test.interviewer1@jobcorp.com", "test", "David Interviewer1", Role.INTERVIWER));
        userDao.save(new User("test.interviewer2@jobcorp.com", "test", "Joseph Interviewer2", Role.INTERVIWER));
    }
}
