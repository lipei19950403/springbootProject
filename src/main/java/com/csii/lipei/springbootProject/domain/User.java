package com.csii.lipei.springbootProject.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	private String userName;
	
	//json不显示该字段
	@JsonIgnore
	private String passWord;
	
	//指定别名
	@JsonProperty("newage")
	private String age;
	
	@JsonFormat(pattern="yyyyMMdd hh:mm:ss",locale="zh",timezone="GTM+8")
	private Date createTime;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(String userName, String passWord, String age, Date createTime) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.age = age;
		this.createTime = createTime;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
