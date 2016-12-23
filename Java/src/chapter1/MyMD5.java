package chapter1;

import java.security.MessageDigest;

public class MyMD5 {
/**
 * java生成字符串md5函数类
 * http://www.cnblogs.com/yanghuahui/archive/2013/06/16/3139411.html
 * 
 */
	private static MessageDigest md5 = null;
	private static MessageDigest sha1 = null;
	//在静态块中初始化，获得md5的单例实例。
	static {
        try {
        	// 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）  
            md5 = MessageDigest.getInstance("MD5");
            sha1 = MessageDigest.getInstance("SHA1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	/**
	 * 测试md5加密效果
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getMd5("hello world"));
		System.out.println(getMd5("123456"));
		System.out.println(getMd5_2("123456"));
	}

	/**
	 * 用于获取一个String的md5值，单函数
	 * @param string str 字符串
	 * @return md5 value
	 */
	public static String getMd5(String str) {
		// 输入的字符串转换成字节数组  
		byte[] bs = md5.digest(str.getBytes());
		StringBuilder sb = new StringBuilder(40);
		for(byte x:bs) {
			if((x & 0xff)>>4 == 0) {
				sb.append("0").append(Integer.toHexString(x & 0xff));
			} else {
				sb.append(Integer.toHexString(x & 0xff));
			}
		}
		return sb.toString();
	}
	
	
	
	
	/**
	 * 用于获取一个String的md5值，配合byteArrayToHex函数
	 * http://www.jb51.net/article/49761.htm
	 * @param string str 字符串
	 * @return md5 value
	 */
	public static String getMd5_2(String str) {
		// 输入的字符串转换成字节数组  
        byte[] inputByteArray = str.getBytes();  
        // inputByteArray是输入字符串转换得到的字节数组  
        md5.update(inputByteArray);  
        // 转换并返回结果，也是字节数组，包含16个元素  
        byte[] resultByteArray = md5.digest();  
        // 字符数组转换成字符串返回  
        return byteArrayToHex(resultByteArray);
	}

	
	public static String byteArrayToHex(byte[] byteArray) {  
		// 首先初始化一个字符数组，用来存放每个16进制字符  
		char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' };  
		// new一个字符数组，这个就是用来组成结果字符串的
		//（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））  
		char[] resultCharArray =new char[byteArray.length * 2];  
		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去  
		int index = 0; 
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];  
			resultCharArray[index++] = hexDigits[b& 0xf];  
		}
		// 字符数组组合成字符串返回  
		return new String(resultCharArray);  
	}

    
}
