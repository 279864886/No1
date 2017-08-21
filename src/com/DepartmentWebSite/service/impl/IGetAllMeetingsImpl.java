package com.DepartmentWebSite.service.impl;

import com.DepartmentWebSite.model.MeetingsDataEntity;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.service.IGetAllMeetings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class IGetAllMeetingsImpl implements IGetAllMeetings {

    private IMySqlImpl imysql;

    public IGetAllMeetingsImpl(){
        this.imysql=new IMySqlImpl();

        this.imysql.setUrl("jdbc:mysql://localhost/department?characterEncoding=UTF-8");
        this.imysql.setUsername("chenwenhao");
        this.imysql.setPassword("cwh@222222");
    }



    @Override
    public MeetingsDataEntity[] GetAllMeetings() throws SQLException {

        this.imysql.connSQL();

        String str="SELECT * FROM meetings WHERE DATE_SUB(CURDATE(),INTERVAL (SELECT WEEKDAY(CURDATE())) DAY) <= DATE(start_date);";
        //String str="select * from meetings";
        ResultSet rs = this.imysql.selectSQL(str);

        int rowCount=0;
        try
        {
            rs.last();
            rowCount = rs.getRow();
        }
        catch (Exception e) {
            // TODO: handle exception
            return null;
        }

        MeetingsDataEntity[] meetings;
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        if(rowCount>0) {
            meetings = new MeetingsDataEntity[rowCount];
            rs.beforeFirst();


            for(int i=0;i<meetings.length;i++)
            {
                rs.next();

                meetings[i]=new MeetingsDataEntity();

                meetings[i].setMeetingStartDate(rs.getTimestamp("start_date"));
                meetings[i].setMeetingEndDate(rs.getTimestamp("end_date"));
                meetings[i].setMeetingContent(rs.getString("content"));
                meetings[i].setMeetingLocate(rs.getString("locate"));
                meetings[i].setMeetingSponsor(rs.getString("sponsor"));
                meetings[i].setMeetingAgent(rs.getString("agent"));
                meetings[i].setMeetingParticipant(rs.getString("participant"));
                meetings[i].setMeetingRemarks(rs.getString("remarks"));


                Calendar cal = new GregorianCalendar();
                cal.setTime(meetings[i].getMeetingStartDate());
                int day = cal.get(Calendar.DAY_OF_WEEK) - 1;
                if (day < 0)
                    day = 0;


                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                meetings[i].setDateDisplay(weekDays[day] + "  " + df.format(meetings[i].getMeetingStartDate()));

                DateFormat df1 = new SimpleDateFormat("HH:mm");
                meetings[i].setStartDisplay(df1.format(meetings[i].getMeetingStartDate()));
                meetings[i].setEndDisplay(df1.format(meetings[i].getMeetingEndDate()));
            }

        }
        else
            return null;

        this.imysql.deconnSQL();

        return meetings;
    }
}
