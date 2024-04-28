package com.project.socialmediamongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParameter(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
<<<<<<< HEAD

		
=======
	
>>>>>>> aeae8b27fa1a0968f4e0dd65227422633880e50d
}
