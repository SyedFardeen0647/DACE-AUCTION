package com.dace.project.Auction.Bidding.Project.Utlities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static String getCurrentDateTime() {
		LocalDateTime datetime1 = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = datetime1.format(format);
	    return formatDateTime;
	}
	public static LocalDateTime getDate(String date) {

		String str = date+" 00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		return dateTime;
	}
}
