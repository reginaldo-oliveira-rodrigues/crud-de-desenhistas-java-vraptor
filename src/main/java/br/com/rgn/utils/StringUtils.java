package br.com.rgn.utils;

public class StringUtils {
	public static boolean isBlank(String info){
		return !(info != null && info.trim() != "");
	}
}
