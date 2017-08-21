package com.quartz.utils.model;

import static com.quartz.utils.util.CronExpressionUtils.every;
import static com.quartz.utils.util.CronExpressionUtils.lastDayOfWeekOfMonth;
import static com.quartz.utils.util.CronExpressionUtils.specificDaysOfWeek;
import static com.quartz.utils.util.CronExpressionUtils.specificHours;
import static com.quartz.utils.util.CronExpressionUtils.specificMinutes;
import static com.quartz.utils.util.CronExpressionUtils.specificMonths;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.quartz.utils.builder.CronExpressionBuilder;

public class GenerateExpression {

	public static void main(String[] args) {
		
		List<Date> minutes = Arrays.asList(new Date());
		List<Date> hours = Arrays.asList(new Date());
		//List<Date> daysOfMonth = Arrays.asList(new Date());
		List<Date> daysOfWeek = Arrays.asList(new Date());
		List<Date> months = Arrays.asList(new Date());
		
		CronExpression cronExpression = new CronExpressionBuilder().withSeconds(every())
				.withMinutes(specificMinutes(minutes))
				.withHours(specificHours(hours))
				.withDaysOfMonth(lastDayOfWeekOfMonth(new Date()))
				.withMonths(specificMonths(months))
				.withDaysOfWeek(specificDaysOfWeek(daysOfWeek))
				.withYears(every())
				.generateExpression();
		System.out.println(cronExpression);

	}

}
