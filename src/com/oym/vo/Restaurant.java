package com.oym.vo;

import java.util.ArrayList;

public abstract class Restaurant {
	
	private String name;
	private String tel; // 02-111-1111
	private String location; //시빼고, 동만
	private int openTime; // 1750 -> 17:50
	private int closeTime;
	//private String category;// "한,중,일,양"
	
	private ArrayList<Review> reviews;
	private ArrayList<Menu> menus;
	
	
	public Restaurant(String name, String tel, String location, int openTime, int closeTime) {
		this.name = name;
		this.tel = tel;
		this.location = location;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	
	public Restaurant(String name, String tel, String location, int openTime, int closeTime, ArrayList<Review> reviews,
			ArrayList<Menu> menus) {
		super();
		this.name = name;
		this.tel = tel;
		this.location = location;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.reviews = reviews;
		this.menus = menus;
	}


	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getLocation() {
		return location;
	}

	public int getOpenTime() {
		return openTime;
	}
	public void ChangeOpenTime(int openTime) {
		this.openTime = openTime;
	}
	public int getCloseTime() {
		return closeTime;
	}
	public void changeCloseTime(int closeTime) {
		this.closeTime = closeTime;
	}


	public ArrayList<Review> getReviews() {
		return reviews;
	}


	public ArrayList<Menu> getMenus() {
		return menus;
	}


	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", tel=" + tel + ", location=" + location + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", reviews=" + reviews.toString() + ", menus=" + menus.toString() + "]"+ "\n";
	}
	

}
