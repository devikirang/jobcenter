package com.jobcenter.service.impl;

import com.jobcenter.dao.CandidateJobDao;
import com.jobcenter.model.*;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.CandidateJobService;
import com.jobcenter.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created on 10/29/2016.
 */
@Service
public class CandidateJobServiceImpl implements CandidateJobService {

    @Autowired
    private CandidateJobDao candidateJobDao;

    @Autowired
    private JobService jobService;

    @Override
    public List<Job> findAllMyJobsInterviewResults(User managerUser) throws BusinessException {
        if (managerUser == null || managerUser.getRole() != Role.MANAGER) {
            throw new BusinessException("Not Authorized.");
        }
        List<Job> jobs = jobService.findAllByManager(managerUser);
        for (Job job : jobs) {
            List<CandidateJob> candidateJobs = candidateJobDao.findAllByJobCode(job.getJobCode());
            for (CandidateJob candidateJob : candidateJobs) {
                double candidateScore = calculateCandidateScore(candidateJob, job);
                BigDecimal candidateScoreBd = new BigDecimal(candidateScore).setScale(2, BigDecimal.ROUND_HALF_UP);
                candidateJob.setCandidateScore(Math.round(candidateScoreBd.doubleValue()));
            }
            // Sort by Score
            Collections.sort(candidateJobs, (o1, o2) -> Double.valueOf(o2.getCandidateScore()).compareTo(o1.getCandidateScore()));
            for (int i = 0; i < candidateJobs.size(); i++) candidateJobs.get(i).setRank(i + 1);
            job.setCandidateJobs(candidateJobs);
        }
        return jobs;
    }

    @Override
    public List<InterviewSession> findMyInterviewSessions(User interviewer) throws BusinessException {
        List<CandidateJob> candidateJobs = candidateJobDao.findAll();
        List<InterviewSession> interviewSessions = candidateJobs.stream()
                .flatMap(candidateJob -> candidateJob.getInterviewSessions().stream())
                .filter(interviewSession -> interviewSession.getInterviewer().getEmail().equals(interviewer.getEmail()))
                .collect(Collectors.toList());
        return interviewSessions;
    }

    @Override
    public List<Job> findMyAppliedJobs(User candidate) throws BusinessException {
        CandidateJob example = new CandidateJob();
        example.setCandidate(new User(candidate.getEmail()));
        List<CandidateJob> candidateJobs = candidateJobDao.findAll(Example.of(example));
        return candidateJobs.stream().map(candidateJob -> jobService.findByJobCode(candidateJob.getJobCode()))
                .collect(Collectors.toList());
    }

    /**
     * The Algorithm to calculate Score for candidate skills.
     * Each Skill Score = Skill Weight(W) * (average Skill Rating(R) by Interviewers)
     * Final Skill Score = Sum of all Skill Scores.
     * W - Skill Weight is defined by Recruiter at the time of posting Job.
     * R - Skill Rating is given by Interviewer at the time of Interview Session.
     * Highest score candidate is the best ranked candidate for job.
     *
     * @return candidate skills score.
     */
    private double calculateCandidateScore(CandidateJob candidateJob, Job job) {
        Map<Skill, List<SkillRating>> candidateSkillMap = new HashMap();
        for (InterviewSession interview : candidateJob.getInterviewSessions()) {
            for (SkillRating skillRating : interview.getSkillRatings()) {
                Skill key = skillRating.getSkill();
                if (!candidateSkillMap.containsKey(key)) {
                    candidateSkillMap.put(key, new ArrayList());
                }
                candidateSkillMap.get(key).add(skillRating);
            }
        }
        double score = 0;
        if (candidateSkillMap.size() > 0) {
            for (Map.Entry<Skill, List<SkillRating>> entry : candidateSkillMap.entrySet()) {
                // Get the skill required weight from the job posting.
                double skillWeight = job.findSkillWeight(entry.getKey());
                double skillAverageRating = entry.getValue().stream()
                        .mapToDouble(SkillRating::getRating).average().getAsDouble();
                score += skillWeight * skillAverageRating;
            }
        }

        return score;
    }
}
