package com.quartz.utils.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 
 * @author Matheus Almeida
 *
 */
public class CronExpressionUtils {

	/**
	 * 
	 * @param value
	 * @return
	 * 
	 */
	public static String specific(String value){
		String result = "";
		if(value == null || !value.equals("")){
			result = "0";
		}
		return result;
	}
	
	/**
	 * 
	 * @return
	 * 
	 */
	public static String every(){
		return "*";
	}
	
	/**
	 * 
	 * @param every
	 * @param startingAt
	 * @return
	 * 
	 */
	public static String everyIncrement(Integer every, Integer startingAt){
		return every + "/" + startingAt;
	}
	
	/**
	 * 
	 * @param seconds
	 * @return
	 * 
	 */
	public static String specificSeconds(List<String> seconds){
		if(seconds != null && !seconds.isEmpty()){
			String result = "";
			for(String value : seconds){
				result += value;
				result += ",";
			}
			return result = result.substring(0, result.length() - 1);
		}else{
			return "0";
		}
	}
	
	/**
	 * 
	 * @param minutes
	 * @return
	 * 
	 */
	public static String specificMinutes(List<String> minutes){
		if(minutes != null && !minutes.isEmpty()){
			String result = "";
			for(String value : minutes){
				result += value;
				result += ",";
			}
			return result = result.substring(0, result.length() - 1);
		}else{
			return "0";
		}
	}
	
	/**
	 * 
	 * @param hours
	 * @return
	 * 
	 */
	public static String specificHours(List<String> hours){
		if(hours != null && !hours.isEmpty()){
			String result = "";
			for(String value : hours){
				result += value;
				result += ",";
			}
			return result = result.substring(0, result.length() - 1);
		}else{
			return "0";
		}
	}
	
	/**
	 * 
	 * @param dates
	 * @return
	 *
	 */
	public static String daysOfWeek(List<Date> dates){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E", Locale.ENGLISH);
		if(dates != null && !dates.isEmpty()){
			String expression = "";
			for(Date date : dates){
				if(!expression.contains(simpleDateFormat.format(date).toUpperCase())){
					expression += simpleDateFormat.format(date).toUpperCase();
					expression += ",";
				}
			}
			return expression = expression.substring(0, expression.length() - 1);
		}else{
			return "0";
		}
	}
	
	/**
	 * 
	 * @param dates
	 * @return
	 * 
	 */
	public static String specificMonths(List<Date> dates){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.ENGLISH);
		if(dates != null && !dates.isEmpty()){
			String expression = "";
			for(Date date : dates){
				if(!expression.contains(simpleDateFormat.format(date).toUpperCase())){
					expression += simpleDateFormat.format(date).toUpperCase();
					expression += ",";
				}
			}
			return expression = expression.substring(0, expression.length() - 1);
		}else{
			return "0";
		}
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * 
	 */
	public static String between(Integer start, Integer end){
		return start + "-" + end;
	}
	
	/**
	 * 
	 * @return
	 * last day of the month
	 */
	public static String lastDayOfMonth(){
		return "L";
	}
	
	/**
	 * 
	 * @return
	 * last weekday of the month
	 */
	public static String lastWeekDayOfMonth(){
		return "LW";
	}
	
}
