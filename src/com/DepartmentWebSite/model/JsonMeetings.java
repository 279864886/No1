package com.DepartmentWebSite.model;

import java.util.List;

public class JsonMeetings {

    private String success;

    private String msg;

    private List<MeetingsDataEntity> meetings;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<MeetingsDataEntity> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<MeetingsDataEntity> meetings) {
        this.meetings = meetings;
    }
}
