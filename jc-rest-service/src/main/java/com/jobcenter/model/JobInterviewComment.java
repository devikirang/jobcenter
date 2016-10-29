package com.jobcenter.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by 10/29/2016.
 */
public class JobInterviewComment {
    @Id
    private String id;

    private User interviewee;
    private String comment;
    private Date dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(User interviewee) {
        this.interviewee = interviewee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
