package com.vidyuth.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateUtils {
	private static final DateTimeFormatter formatter = ISODateTimeFormat.dateHourMinuteSecond();
	private static final DateTimeFormatter sqlFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	private static final DateTimeFormatter sqlFormatter1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.s");
	private static final DateTimeFormatter twitterStupidFormatter = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss Z yyyy");
	private static final DateTimeFormatter date = DateTimeFormat.forPattern("dd-MM-yyyy");
	
	public static String convertCurrentTimeStampToSQLTimeStamp(){
		DateTime now = new DateTime(DateTimeZone.UTC);
		return formatter.print(now);
	}
	
	public static String converFromSQLTimeStamp(String timeStamp){
		DateTime dt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(timeStamp);
		return dt.toString();
	}
	public static String converFromSQLTimeStamp1(String timeStamp){
		DateTime dt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.s").parseDateTime(timeStamp);
		return dt.toString();
	}
	
	public static String converToSQLTimeStamp(String timeStamp){
		DateTime dt = date.parseDateTime(timeStamp);
		return sqlFormatter.print(dt);
	}
	
	
	
	public static int totalYearsFromNow(String timeStamp){
		DateTime dt = new DateTime(timeStamp);
		Period period = new Period(dt,new DateTime());
		return period.getYears();
	}

	public static int convertDOBTOAge(Date dob) {
		DateTime dt = sqlFormatter1.parseDateTime(dob.toString());
		Period pr = new Period(dt,new DateTime());
		return pr.getYears();
	}
	
	public static String converAgeToDobInSQLFormat(int age){
		DateTime dt = new DateTime().minusYears(age).withTimeAtStartOfDay();
		return sqlFormatter.print(dt);
	}
	
	public static String converTwitterToSqlFormat(String data){
		DateTime dt = twitterStupidFormatter.parseDateTime(data);
		return formatter.print(dt);
	}
	
	public static boolean isWeekDay(){
		LocalDate dt = new LocalDate();
		if(dt.getDayOfWeek()<=5){
			return true;
		}
		return false;
	}
	
	public static boolean isWeekDay(String tz){
		LocalDate dt = LocalDate.now(DateTimeZone.forID(tz));
		if(dt.getDayOfWeek()<=5){
			return true;
		}
		return false;
	}

	public static String timeAtBeginingOfDayInSQLFormat() {
		DateTime dt = new DateTime().withTimeAtStartOfDay(); 
		return formatter.print(dt);
	}

	public static DateTime dateTimeNowInUTC() {
		return DateTime.now(DateTimeZone.UTC);
	}
	
	public static Date convertStringToDate(String dt){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss"); 
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = null;
		try {
			date = df.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static DateTime dateTimeAtStartOfTheDayInUTC(){
		return DateTime.now(DateTimeZone.UTC).withTimeAtStartOfDay();
	}
	
}
