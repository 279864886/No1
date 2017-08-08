package com.DepartmentWebSite.model;

import java.sql.Timestamp;
import java.util.Date;

public class MeetingsDataEntity {

    private Timestamp meetingStartDate;

    private Timestamp meetingEndDate;

    private String meetingContent;

    private String meetingLocate;

    private String meetingSponsor;

    private String meetingAgent;

    private String meetingParticipant;

    private String meetingRemarks;

    private String dateDisplay;

    private String StartDisplay;

    private String EndDisplay;

    public MeetingsDataEntity(){

    }


    public String getMeetingSponsor() {
        return meetingSponsor;
    }

    public void setMeetingSponsor(String meetingSponsor) {
        this.meetingSponsor = meetingSponsor;
    }

    public Timestamp getMeetingStartDate() {
        return meetingStartDate;
    }

    public void setMeetingStartDate(Timestamp meetingStartDate) {
        this.meetingStartDate = meetingStartDate;
    }

    public Timestamp getMeetingEndDate() {
        return meetingEndDate;
    }

    public void setMeetingEndDate(Timestamp meetingEndDate) {
        this.meetingEndDate = meetingEndDate;
    }

    public String getMeetingContent() {
        return meetingContent;
    }

    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent;
    }

    public String getMeetingLocate() {
        return meetingLocate;
    }

    public void setMeetingLocate(String meetingLocate) {
        this.meetingLocate = meetingLocate;
    }

    public String getMeetingAgent() {
        return meetingAgent;
    }

    public void setMeetingAgent(String meetingAgent) {
        this.meetingAgent = meetingAgent;
    }

    public String getMeetingParticipant() {
        return meetingParticipant;
    }

    public void setMeetingParticipant(String meetingParticipant) {
        this.meetingParticipant = meetingParticipant;
    }

    public String getMeetingRemarks() {
        return meetingRemarks;
    }

    public void setMeetingRemarks(String meetingRemarks) {
        this.meetingRemarks = meetingRemarks;
    }

    public String getStartDisplay() {
        return StartDisplay;
    }

    public void setStartDisplay(String startDisplay) {
        StartDisplay = startDisplay;
    }

    public String getEndDisplay() {
        return EndDisplay;
    }

    public void setEndDisplay(String endDisplay) {
        EndDisplay = endDisplay;
    }


    public String getDateDisplay() {
        return dateDisplay;
    }

    public void setDateDisplay(String dateDisplay) {
        this.dateDisplay = dateDisplay;
    }
}
