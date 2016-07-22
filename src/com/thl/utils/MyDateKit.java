package com.thl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyDateKit {

	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	private static final Logger LOG = LoggerFactory.getLogger(MyDateKit.class);	

	/**
	 * 
	 * 格式化当前时间，自定义格式 年月日 时分秒
	 * 
	 * @return
	 */
	public static String format(String format) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(format);
		return LocalDateTime.now().format(ofPattern);
	}
	
	public static LocalDate parse(String date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(date, formatter);
	}

	/**
	 * @desc 时间的格式只能是yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static long getSecondByDate(String args) {
		SimpleDateFormat format = new SimpleDateFormat(MyDateKit.DATE_FORMAT);
		long epochSecond = 0;
		try {
			Date date = format.parse(args);
			epochSecond = date.toInstant().getEpochSecond();
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}
		return epochSecond;
	}

	/**
	 * @Title 时间戳转日期
	 * @Description TODO
	 * @author TaoHanLin
	 * @date 2016年3月2日 下午1:27:24
	 * @action formatDate
	 * @param recordTime
	 * @return
	 */
	public static String formatDate(Long recordTime) {
		SimpleDateFormat format = new SimpleDateFormat("M.d");
		return format.format(recordTime * 1000);
	}

	/**
	 * 
	 * 格式化当前时间，自定义格式 年月日
	 * 
	 * @return
	 */
	public static String localDateFormat(String format) {
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(format);
		return LocalDate.now().format(ofPattern);
	}
	
	/**
	 * 获取当前时间（单位 秒）
	 * 
	 * @return
	 */
	public static long currentSecond() {
		return Instant.now().getEpochSecond();
	}

	/**
	 * 邮箱验证的有效时间
	 */

	public static String getActivateTime(int days, String format) {
		LocalDateTime now = LocalDateTime.now().plusDays(days);
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(format);
		return now.format(ofPattern);
	}

	public static String getActivateTime(int days) {
		return MyDateKit.getActivateTime(days, DATE_TIME_FORMAT);

	}
	
	/**
	 * 
	 * @Description 时间（yyyy-MM-dd HH:mm:ss）转时间戳
	 * @author 薛金华
	 * @date 2016年3月28日 下午3:58:47
	 * @action getLongTime
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static long getLongTime(String time) throws ParseException{
	  SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
      Date date = format.parse(time);
      long  timeLong = date.getTime();
      return timeLong/1000;
	}
	
}
