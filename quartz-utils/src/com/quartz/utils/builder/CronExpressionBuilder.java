package com.quartz.utils.model;

/**
 * 
 * @author Matheus Almeida
 *
 */
public class CronExpressionBuilder {
	
	private String seconds;
	private String minutes;
	private String hours;
	private String daysOfMonth;
	private String daysOfWeek;
	private String months;
	private String years;
	
	public CronExpressionBuilder withSeconds(String seconds){
		this.seconds = seconds;
		return this;
	}

	public CronExpressionBuilder withMinutes(String minutes){
		this.minutes = minutes;
		return this;
	}
	
	public CronExpressionBuilder withHours(String hours){
		this.hours = hours;
		return this;
	}
	
	public CronExpressionBuilder withDaysOfMonth(String daysOfMonth){
		this.daysOfMonth = daysOfMonth;
		return this;
	}
	
	public CronExpressionBuilder withDaysOfWeek(String daysOfWeek){
		this.daysOfWeek = daysOfWeek;
		return this;
	}
	
	public CronExpressionBuilder withMonths(String months){
		this.months = months;
		return this;
	}
	
	public CronExpressionBuilder withYears(String years){
		this.years = years;
		return this;
	}
	
	public CronExpression generateExpression(){
		return new CronExpression(seconds, minutes, hours, daysOfMonth, daysOfWeek, months, years);
	}
	
}
