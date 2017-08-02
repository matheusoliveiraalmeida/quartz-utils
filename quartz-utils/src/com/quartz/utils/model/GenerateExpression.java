package com.quartz.utils.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.quartz.utils.model.CronExpressionUtils.*;

public class GenerateExpression {

	public static void main(String[] args) {
		
		//String seconds = "";
		String minutes = "";
		//String hours = "";
		String daysOfMonth = "";
		List<Date> daysOfWeek = Arrays.asList(new Date(), new Date());
		List<Date> months = Arrays.asList(new Date(), new Date());
		String years = "";
		
		CronExpression cronExpression = new CronExpressionBuilder().withSeconds(every()).withMinutes(minutes)
				.withHours(specificHours(null)).withDaysOfMonth(daysOfMonth).withDaysOfWeek(daysOfWeek(daysOfWeek))
				.withMonths(specificMonths(months)).withYears(years).generateExpression();
		System.out.println(cronExpression);

	}

}
