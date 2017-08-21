package com.quartz.utils.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.quartz.utils.enums.DaysWeek;

/**
 * 
 * @author Matheus Almeida
 *
 */
public class CronExpressionUtils {
	
	private static boolean specificDaysOfMonth;
	private static boolean specificDaysOfWeek;
	private static boolean lastDayOfMonth;
	private static boolean lastWeekDayOfMonth;
	private static boolean lastDayOfWeekOfMonth;
	private static boolean daysBeforeEndOfMonth;
	private static boolean nearestWeekday;
	private static boolean onInitDayOfWeek;
	private static boolean everyDayStartingInDayOfWeek;
	private static boolean everyDayStartingInDayOfMonth;

	/**
	 * 
	 * @param value
	 * @return
	 * 
	 */
	public static String specific(String value){
		if(value == null || value.equals("")){
			return "0";
		}
		return value;
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
	public static String specificSeconds(List<Date> seconds){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ss", Locale.ENGLISH);
		if(seconds != null && !seconds.isEmpty()){
			String expression = "";
			for(Date second : seconds){
				if(!expression.contains(simpleDateFormat.format(second).toLowerCase())){
					expression += simpleDateFormat.format(second).toUpperCase();
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
	 * @param minutes
	 * @return
	 * 
	 */
	public static String specificMinutes(List<Date> minutes){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm", Locale.ENGLISH);
		if(minutes != null && !minutes.isEmpty()){
			String expression = "";
			for(Date minute : minutes){
				if(!expression.contains(simpleDateFormat.format(minute).toLowerCase())){
					expression += simpleDateFormat.format(minute).toUpperCase();
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
	 * @param hours
	 * @return
	 * 
	 */
	public static String specificHours(List<Date> hours){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", Locale.ENGLISH);
		if(hours != null && !hours.isEmpty()){
			String expression = "";
			for(Date hour : hours){
				if(!expression.contains(simpleDateFormat.format(hour).toUpperCase())){
					expression += simpleDateFormat.format(hour).toUpperCase();
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
	public static String specificDaysOfWeek(List<Date> dates){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E", Locale.ENGLISH);
		if(dates != null && !dates.isEmpty()){
			String expression = "";
			if(!specificDaysOfMonth && !lastDayOfMonth && !lastWeekDayOfMonth && !lastDayOfWeekOfMonth && !daysBeforeEndOfMonth
					&& !nearestWeekday && !everyDayStartingInDayOfMonth){
				for(Date dayOfWeek : dates){
					if(!expression.contains(simpleDateFormat.format(dayOfWeek).toUpperCase())){
						expression += simpleDateFormat.format(dayOfWeek).toUpperCase();
						expression += ",";
					}
					specificDaysOfWeek = true;
				}
				return expression = expression.substring(0, expression.length() - 1);
			}else{
				System.err.println("Support for specifying both a day-of-week AND a day-of-month parameter is not implemented.");
				return "?";
			}
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
	public static String specificDaysOfMonth(List<Date> dates){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("u", Locale.ENGLISH);
		if(dates != null && !dates.isEmpty()){
			String expression = "";
			if(!specificDaysOfWeek && !onInitDayOfWeek && !everyDayStartingInDayOfWeek){
				for(Date dayOfMonth : dates){
					if(!expression.contains(simpleDateFormat.format(dayOfMonth).toUpperCase())){
						expression += simpleDateFormat.format(dayOfMonth).toUpperCase();
						expression += ",";
					}
					specificDaysOfMonth = true;
				}
				return expression = expression.substring(0, expression.length() - 1);
			}else{
				System.err.println("Support for specifying both a day-of-month AND a day-of-week parameter is not implemented.");
				return "?";
			}
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
			for(Date month : dates){
				if(!expression.contains(simpleDateFormat.format(month).toUpperCase())){
					expression += simpleDateFormat.format(month).toUpperCase();
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
	 * @param init
	 * @param date
	 * @return
	 * every (init) day(s) starting on parameter(date) day of week
	 */
	@SuppressWarnings("static-access")
	public static String everyDayStartingInDayOfWeek(int init, Date date){
		if(init > 0 && init < 8){
			if(date != null){
				GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, 0, 0, 0);
				calendar.setTime(date);
				everyDayStartingInDayOfWeek = true;
				return calendar.get(calendar.DAY_OF_WEEK) + "/" + init;
			}
		}else{
			System.err.println("init must be between 1 and 7.");
		}
		return "";
	}
	
	/**
	 * 
	 * @param init
	 * @param date
	 * @return
	 * every (init) day(s) starting on parameter(date) day of month
	 */
	@SuppressWarnings("static-access")
	public static String everyDayStartingInDayOfMonth(int init, Date date){
		if(init > 0 && init < 32){
			if(date != null){
				GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, 0, 0, 0);
				calendar.setTime(date);
				everyDayStartingInDayOfMonth = true;
				return calendar.get(calendar.DAY_OF_MONTH) + "/" + init;
			}
		}
		return "";
	}
	
	/**
	 * 
	 * @return
	 * last day of the month
	 */
	public static String lastDayOfMonth(){
		lastDayOfMonth = true;
		return "L";
	}
	
	/**
	 * 
	 * @return
	 * last weekday of the month
	 */
	public static String lastWeekDayOfMonth(){
		lastWeekDayOfMonth = true;
		return "LW";
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 * On the last day of week of the month
	 */
	@SuppressWarnings("static-access")
	public static String lastDayOfWeekOfMonth(Date date){
		if(date != null){
			GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, 0, 0, 0);
			calendar.setTime(date);
			for(DaysWeek dayWeek : DaysWeek.values()){
				if(dayWeek.getId() == calendar.get(calendar.DAY_OF_WEEK)){
					lastDayOfWeekOfMonth = true;
					return dayWeek.getId() + "L";
				}
			}
		}
		return "";
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 * day(s) before the end of the month
	 */
	@SuppressWarnings("static-access")
	public static String daysBeforeEndOfMonth(Date date){
		if(date != null){
			GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, 0, 0, 0);
			calendar.setTime(date);
			daysBeforeEndOfMonth = true;
			return "L-" + calendar.get(calendar.DAY_OF_MONTH);
		}
		return "";
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 * nearest weekday
	 */
	@SuppressWarnings("static-access")
	public static String nearestWeekday(Date date){
		if(date != null){
			GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, 0, 0, 0);
			calendar.setTime(date);
			nearestWeekday = true;
			return calendar.get(calendar.DAY_OF_MONTH) + "W";
		}
		return "";
	}
	
	/**
	 * 
	 * @param init
	 * @param date
	 * @return
	 * on init day of week of the month
	 * 
	 */
	@SuppressWarnings("static-access")
	public static String onInitDayOfWeek(int init, Date date){
		if(init > 0 && init < 6){
			if(date != null){
				GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, 0, 0, 0);
				calendar.setTime(date);
				onInitDayOfWeek = true;
				return calendar.get(calendar.DAY_OF_WEEK) + "#" + init;
			}
		}else{
			System.err.println("init must be between 1 and 5.");
		}
		return "";
	}
	
}
