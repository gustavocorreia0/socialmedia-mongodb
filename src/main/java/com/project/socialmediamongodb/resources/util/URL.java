package com.project.socialmediamongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodeParameter(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate(String data, Date defaultValue){
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		sdt.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdt.parse(data);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
}
