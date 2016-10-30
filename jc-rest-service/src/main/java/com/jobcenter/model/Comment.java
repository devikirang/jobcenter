package com.jobcenter.model;

import java.util.Date;

/**
 * Created by 10/29/2016.
 */
public class Comment {
    private User interviewee;
    private String comment;
    private Date dateTime;

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
