package com.quartz.utils.model;

/**
 * 
 * @author Matheus Almeida
 *
 */
public class CronExpression {

	private String seconds;
	private String minutes;
	private String hours;
	private String daysOfMonth;
	private String daysOfWeek;
	private String months;
	private String years;
	
	public CronExpression(String seconds, String minutes, String hours,
			String daysOfMonth, String months, String daysOfWeek, String years){
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
		this.daysOfMonth = daysOfMonth;
		this.months = months;
		this.daysOfWeek = daysOfWeek;
		this.years = years;
	}

	public String getSeconds() {
		return seconds;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getDaysOfMonth() {
		return daysOfMonth;
	}

	public void setDaysOfMonth(String daysOfMonth) {
		this.daysOfMonth = daysOfMonth;
	}

	public String getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return seconds + " " + minutes + " " + hours + " " + daysOfMonth + " " + daysOfWeek + " " + months + " " + years;
	}
	
}
