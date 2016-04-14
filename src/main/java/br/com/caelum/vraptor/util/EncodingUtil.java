package br.com.caelum.vraptor.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class EncodingUtil {
	
	private static final String ISO_8859_1 = "ISO-8859-1";
	private static final String UTF_8 = "UTF-8";

	public static String setEncodingUTF8(String str){
		String parseEncoding = str;
		try {
			if(!isEncodedUTF8(str)){
				parseEncoding = new String(str.getBytes(ISO_8859_1),UTF_8);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return parseEncoding;
	}
	
	private static boolean isEncodedUTF8(String text){
	    Charset charset = Charset.forName(UTF_8);
	    String checked=new String(text.getBytes(charset),charset);
	    return !checked.equals(text);
	}

}
