package chapter1;

import java.io.UnsupportedEncodingException;

// 获取字符串 编码格式
public class EncodingDemo {
	public static void main(String[] args) {
		String str1="this is a 二胡";
		System.out.println(str1);
		System.out.println("charset: " + MyUtils.getEncode(str1));
	}
}



class MyUtils{
	public static final String[] encodes = new String[] 
			{  "GBK", "GB2312", "ISO-8859-1", "ISO-8859-2", "UTF-8" };
	
	//确定给定字符串的编码格式
	public static String getEncode(String str) {
		byte[] data = str.getBytes();
		byte[] _byte = null;
		out:for (int i = 0; i < encodes.length; i++) {
			try {
				_byte = str.getBytes(encodes[i]);
				if (_byte.length!=data.length)
					continue;
				for (int j = 0; j < _byte.length; j++) {
					if (_byte[j] != data[j]) {
						continue out;
					}
				}
				return encodes[i];
			} catch (UnsupportedEncodingException e) {
				continue;
			}
		}
		return null;
	}
}