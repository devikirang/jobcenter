package com.jobcenter.model;

import org.springframework.data.annotation.Id;

import java.util.*;

/**
 * Created on 10/29/2016.
 */
public class JobInterview {
    @Id
    private String id;

    private Date scheduledDate;
    private JobApplication jobApplication;
    private List<InterviewSession> interviewSessions;
    private String notes;
    private List<Comment> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public JobApplication getJobApplication() {
        return jobApplication;
    }

    public void setJobApplication(JobApplication jobApplication) {
        this.jobApplication = jobApplication;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<InterviewSession> getInterviewSessions() {
        return interviewSessions;
    }

    public void setInterviewSessions(List<InterviewSession> interviewSessions) {
        this.interviewSessions = interviewSessions;
    }

    /**
     * The Algorithm to calculate Score for a candidate skill.
     * Get the average of the Skill rating from multiple interviews.
     * Multiple the skill rating with skillWeight
     * And finally add to the user total score.
     * Higher the score means the candidate is the best fit for the job.
     * @return candidate skill score.
     */
    public double getCandidateScore() {
        Map<Skill, List<CandidateSkill>> candidateSkillMap = new HashMap();
        if (this.interviewSessions != null) {
            for (InterviewSession interview : interviewSessions) {
                if (interview.getCandidateSkills() != null) {
                    for (CandidateSkill candidateSkill : interview.getCandidateSkills()) {
                        Skill key = candidateSkill.getSkill();
                        if (!candidateSkillMap.containsKey(key)) {
                            candidateSkillMap.put(key, new ArrayList());
                        }
                        candidateSkillMap.get(key).add(candidateSkill);
                    }
                }
            }
        }

        double score = 0;
        if (candidateSkillMap.size() > 0) {
            for (Map.Entry<Skill, List<CandidateSkill>> entry : candidateSkillMap.entrySet()) {
                // Get the skill required weight from the job posting.
                double skillWeight = jobApplication.getJob().findSkillWeight(entry.getKey());
                double skillAverageRating = entry.getValue().stream()
                        .mapToDouble(CandidateSkill::getRating).average().getAsDouble();
                score += skillWeight * skillAverageRating;
            }
        }

        return score;
    }
}
