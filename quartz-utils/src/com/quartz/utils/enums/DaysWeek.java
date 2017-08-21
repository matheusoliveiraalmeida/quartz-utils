package com.quartz.utils.enums;

public enum DaysWeek {

	SUNDAY(1, "Sunday"),
	MONDAY(2, "Monday"),
	TUESDAY(3, "Tuesday"),
	WEDNESDAY(4, "Wednesday"),
	THURSDAY(5, "Thursday"),
	FRIDAY(6, "Friday"),
	SATURDAY(7, "Saturday");
	
	private int id;
	private String name;
	
	private DaysWeek(int id, String nome) {
		this.id = id;
		this.name = nome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
