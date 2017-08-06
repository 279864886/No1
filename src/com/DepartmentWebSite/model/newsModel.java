package com.DepartmentWebSite.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class newsModel {
	
	private String title;
	
	private String newsID;	
	
	private String section;
	
	private Date releaseDate; 
	
	private String releasePerson;
	
	private String text;
	
	private List<String> accessory=new ArrayList<String>();
	
	private List<String> img=new ArrayList<String>();

	public List<String> getImg() {
		return img;
	}

	public void setImg(List<String> img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsID() {
		return newsID;
	}

	public void setNewsID(String newsID) {
		this.newsID = newsID;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleasePerson() {
		return releasePerson;
	}

	public void setReleasePerson(String releasePerson) {
		this.releasePerson = releasePerson;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<String> accessory) {
		this.accessory = accessory;
	}

	public void addAccessory(String fileName){
		this.accessory.add(fileName);
	}
	
	
	
	

}
