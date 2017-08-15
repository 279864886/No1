package com.DepartmentWebSite.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;
import com.DepartmentWebSite.service.IGetCurrentNews;

public class IGetCurrentNewsImpl implements IGetCurrentNews {

    private IMySqlImpl imysql;
    private String PhotoID;

    public IGetCurrentNewsImpl() {
        this.imysql = new IMySqlImpl();

        this.imysql.setUrl("jdbc:mysql://localhost/department?characterEncoding=UTF-8");
        this.imysql.setUsername("chenwenhao");
        this.imysql.setPassword("cwh@222222");
    }


    public String[] GetAccessoryFiles(String newsID) throws SQLException {
        String[] re = null;

        this.imysql.connSQL();

        ResultSet rs = this.imysql.selectSQL("select * from accessory where newsID='" + newsID + "';");

        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        if (rowCount > 0)
            re = new String[rowCount];
        else
            return null;

        if (re != null) {
            rs.beforeFirst();

            for (int i = 0; i < re.length; i++) {
                rs.next();
                re[i] = rs.getString("fileName");
            }
        }

        this.imysql.deconnSQL();

        return re;
    }

    public String[] GetPhotos(String newsID) throws SQLException {
        String[] re = null;

        this.imysql.connSQL();

        ResultSet rs = this.imysql.selectSQL("select * from photo where newsID='" + newsID + "';");

        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        if (rowCount > 0)
            re = new String[rowCount];
        else
            return null;

        if (re != null) {
            rs.beforeFirst();

            for (int i = 0; i < re.length; i++) {
                rs.next();
                re[i] = rs.getString("photoName");
            }
        }

        this.imysql.deconnSQL();

        return re;
    }


    @Override
    public newsModel GetCurrentNews(String newsID) throws SQLException {
        // TODO Auto-generated method stub

        newsModel re = new newsModel();

        this.imysql.connSQL();

        ResultSet rs = this.imysql.selectSQL("select * from news where newsID='" + newsID + "';");

        String[] accessory = GetAccessoryFiles(newsID);
        String[] photo = GetPhotos(newsID);

        if (rs.next()) {
            re.setTitle(rs.getString("newsTitle"));
            re.setText(rs.getString("newsText"));

            if (accessory != null)
                re.setAccessory(java.util.Arrays.asList(accessory));
            else
                re.setAccessory(null);

            if (photo != null)
                re.setImg(java.util.Arrays.asList(photo));
            else
                re.setImg(null);


            this.imysql.deconnSQL();
            return re;
        } else {
            this.imysql.deconnSQL();
            return null;
        }

    }

    @Override
    public photoModel GetCurrentNewsPhoto(String newsID) throws SQLException {

        newsModel news = GetCurrentNews(newsID);

        if (news != null) {
            photoModel photo = new photoModel();

            this.imysql.connSQL();

            //String sql=String.format(format, args)

            String sql="select * from photo where newsID='"+newsID+"';";

            ResultSet rs = this.imysql.selectSQL(sql);

            if (rs != null) {
                if (rs.next()) {
                    photo.setPhotoName(rs.getString("photoName"));
                    photo.setNewsID(newsID);
                    return photo;
                }
            }
        }


        return null;
    }

}
