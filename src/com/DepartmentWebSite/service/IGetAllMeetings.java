package com.DepartmentWebSite.service;

import com.DepartmentWebSite.model.MeetingsDataEntity;

import java.sql.SQLException;

public interface IGetAllMeetings {

    MeetingsDataEntity[] GetAllMeetings() throws SQLException;

}
