package com.quartz.utils.model;

import static com.quartz.utils.util.CronExpressionUtils.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.quartz.utils.builder.CronExpressionBuilder;

public class GenerateExpression {

	public static void main(String[] args) {
		
		Calendar monday = Calendar.getInstance();
		monday.set(Calendar.DAY_OF_WEEK, 2);
		Calendar tuesday = Calendar.getInstance();
		tuesday.set(Calendar.DAY_OF_WEEK, 3);
		Calendar wednesday = Calendar.getInstance();
		wednesday.set(Calendar.DAY_OF_WEEK, 4);
		Calendar thursday = Calendar.getInstance();
		thursday.set(Calendar.DAY_OF_WEEK, 5);
		Calendar friday = Calendar.getInstance();
		friday.set(Calendar.DAY_OF_WEEK, 6);
		
		List<Date> daysOfWeek = Arrays.asList(monday.getTime(), tuesday.getTime(), wednesday.getTime(), thursday.getTime(), friday.getTime());

		Calendar entrance = Calendar.getInstance();
		entrance.set(Calendar.HOUR_OF_DAY, 8);
		Calendar lunchInput = Calendar.getInstance();
		lunchInput.set(Calendar.HOUR_OF_DAY, 12);
		Calendar lunchOutput = Calendar.getInstance();
		lunchOutput.set(Calendar.HOUR_OF_DAY, 13);
		Calendar exit = Calendar.getInstance();
		exit.set(Calendar.HOUR_OF_DAY, 18);
		
		List<Date> hours = Arrays.asList(entrance.getTime(), lunchInput.getTime(), lunchOutput.getTime(), exit.getTime());
		
		CronExpression cronExpression = new CronExpressionBuilder()
				.withSeconds(specificSeconds(null))
				.withMinutes(specificMinutes(null))
				.withHours(specificHours(hours))
				.withDaysOfMonth(specific("?"))
				.withMonths(every())
				.withDaysOfWeek(specificDaysOfWeek(daysOfWeek))
				.withYears(every())
				.generateExpression();
		System.out.println(cronExpression);

	}
	
}
