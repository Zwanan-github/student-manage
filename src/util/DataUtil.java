package util;

import java.util.regex.Pattern;

/**
 * 数据工具类
 * @author hu'hao
 *
 */
public class DataUtil {
	
	/**
	 * 判断字符串是否为数字
	 * @param str 被判断的字符串
	 * @return
	 */
	public static boolean isInteger(String str) { 
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); 
        return pattern.matcher(str).matches(); 
	}	
}
