package com.jobcenter.service.impl;

import com.jobcenter.dao.CandidateJobDao;
import com.jobcenter.dao.JobDao;
import com.jobcenter.model.*;
import com.jobcenter.service.BusinessException;
import com.jobcenter.service.CandidateJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created on 10/29/2016.
 */
@Service
public class CandidateJobServiceImpl implements CandidateJobService {

    @Autowired
    private CandidateJobDao candidateJobDao;

    @Autowired
    private JobDao jobDao;

    @Override
    public List<CandidateJob> findAllCandidateJobsByJobCode(String jobCode, User requestedUser) throws BusinessException {
        if (requestedUser == null || requestedUser.getRole() != Role.INTERVIWER || requestedUser.getRole() != Role.RECURITER) {
            throw new BusinessException("Not Authorized.");
        }
        List<CandidateJob> candidateJobs = candidateJobDao.findAllByJobCode(jobCode);
        Job job = jobDao.findByJobCode(jobCode);
        for (CandidateJob candidateJob : candidateJobs) {
            double candidateScore = calculateCandidateScore(candidateJob, job);
            candidateJob.setCandidateScore(candidateScore);
        }
        // Sort by Score
        Collections.sort(candidateJobs, (o1, o2) -> Double.valueOf(o1.getCandidateScore()).compareTo(o2.getCandidateScore()));
        return candidateJobs;
    }


    /**
     * The Algorithm to calculate Score for a candidate skill.
     * Get the average of the Skill rating from multiple interviews.
     * Multiple the skill rating with skillWeight
     * And finally add to the user total score.
     * Higher the score means the candidate is the best fit for the job.
     *
     * @return candidate skill score.
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
