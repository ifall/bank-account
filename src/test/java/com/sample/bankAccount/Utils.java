package com.sample.bankAccount;

import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {

	public static Date getDate(int day, int month, int year) {
		return new GregorianCalendar(year, month - 1, day).getTime();
	}
}
