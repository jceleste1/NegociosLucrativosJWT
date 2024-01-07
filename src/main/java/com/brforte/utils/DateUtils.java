package com.brforte.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String dateNow() {

		String formattedDate = "";
		try {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			formattedDate = myDateObj.format(myFormatObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDate;
	}

}
