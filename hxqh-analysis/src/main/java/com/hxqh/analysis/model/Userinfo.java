package com.hxqh.analysis.model;

import java.io.Serializable;


/**
 * The persistent class for the userinfo database table.
 * 
 */
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userid;

	private int age;

	private String area;

	private String birthday;

	private String email;

	private int telephone;

	private String username;

	public Userinfo() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}