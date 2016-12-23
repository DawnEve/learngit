
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StrCounter {

	public static void main(String[] args) {
		//String str = "The quick   brown fox jumps over a lazy dog.a cunning fox jumps over the high box!";
		
		String str33="7577085_C_T  7577097_C_T  7577105_G_T  7577114_C_A  7577114_C_T  7577121_G_A  7577138_C_G  7577141_C_G  7577142_C_G  7577142_C_T  7577512_G_C  7577532_G_A  7577536_T_A  7577539_G_A  7577556_C_A  7577568_C_A  7577581_A_G  7577596_A_T  7578190_T_C  7578191_A_T  7578203_C_A  7578205_C_A  7578205_C_A  7578206_T_A  7578235_T_C  7578236_A_C  7578271_T_A  7578271_T_C  7578393_A_C  7578403_C_A  7578404_A_T  7578406_C_T  7578427_T_C  7578442_T_C  7578442_T_C  7578461_C_A  7578461_C_A  7578475_G_A  7578496_A_G  7578502_A_T  7578520_A_T  7579349_A_C  7579349_A_G";              
		String str35="7572989_C_A  7576857_A_T  7577082_C_T  7577094_G_A  7577094_G_A  7577094_G_A  7577097_C_G  7577099_C_G  7577105_G_A  7577106_G_T  7577118_C_A  7577120_C_A  7577120_C_T  7577120_C_T  7577124_C_A  7577124_C_T  7577518_T_A  7577535_C_G  7577538_C_T  7577538_C_T  7577538_C_T  7577538_C_T  7577539_G_A  7577547_C_T  7577550_C_A  7577556_C_A  7577559_G_C  7577568_C_T  7577568_C_T  7577568_C_T  7577574_T_C  7577574_T_C  7577586_A_T  7578190_T_C  7578190_T_C  7578190_T_C  7578206_T_C  7578272_G_A  7578280_G_A  7578395_G_A  7578403_C_A  7578403_C_T  7578406_C_T  7578406_C_T  7578413_C_A  7578413_C_A  7578413_C_T  7578416_C_A  7578442_T_C  7578461_C_A  7578466_G_T  7578466_G_T  7578475_G_A  7578526_C_G  7579329_T_C  7579355_A_T  7579361_A_G";       
		String str32="7574017_C_A  7574018_G_A  7576853_C_G  7577085_C_T  7577094_G_A  7577094_G_A  7577094_G_A  7577094_G_A  7577094_G_A  7577105_G_T  7577106_G_A  7577106_G_C  7577120_C_A  7577120_C_A  7577120_C_T  7577121_G_A  7577124_C_G  7577124_C_T  7577153_C_A  7577507_T_A  7577509_C_T  7577514_G_A  7577517_A_C  7577518_T_A  7577538_C_T  7577538_C_T  7577538_C_T  7577538_C_T  7577545_T_C  7577547_C_T  7577547_C_T  7577547_C_T  7577547_C_T  7577548_C_A  7577548_C_G  7577559_G_A  7577568_C_A  7577586_A_G  7578190_T_C  7578190_T_C  7578191_A_C  7578199_A_C  7578204_A_C  7578217_G_A  7578265_A_G  7578269_G_A  7578271_T_C  7578272_G_A  7578272_G_T  7578280_G_A  7578394_T_C  7578395_G_A  7578395_G_A  7578395_G_C  7578403_C_T  7578406_C_T  7578413_C_T  7578461_C_A  7578479_G_A  7578518_C_G  7578526_C_A  7578527_A_G  7578535_T_C  7578551_A_T  7578554_A_G  7579344_G_A  7579345_C_A  7579361_A_C";       

		//从文件读取
		try{
			if(args.length>0){
				System.out.println("数据来源："+args[0]);
				File file=new File(args[0]);
				if(file.exists()){
					FileReader fr=new FileReader(file);
					BufferedReader bf=new BufferedReader(fr);
					str33=bf.readLine();
					str35=bf.readLine();
					str32=bf.readLine();
					bf.close();
					fr.close();
				}else{
					System.out.println("文件"+file+"不存在！");
					System.exit(0);
				}
			}else{
				System.out.println("数据来源：示例数据");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	    str33=str_unique(str33);//过滤掉重复序列
	    str35=str_unique(str35);//过滤掉重复序列
	    str32=str_unique(str32);//过滤掉重复序列
	    
	    String str=str33+"  "+str35+"  "+str32;
		wordCounter(str);
	}
	/**
	 * 统计单词频数
	 */
	//分割单词，使用空格、,.?!-等英文标点分割。
	private static void wordCounter(String str) {
	    str=str.trim();//去掉两端空白
	    str=str.toLowerCase();
	    String regEx = "[\\s',?.!\\-]+"; // 正则表达式规则,至少1个空格
	    String[] arr=str.split(regEx);//分割字符串
	    
	    //创建一个map
	    HashMap<String,Integer> map=new HashMap<String,Integer>();
	    
	    for (int i = 0; i < arr.length; i++) {
	    	String s=arr[i];
	    	if(map.containsKey(s)){
	    		map.put(s, map.get(s) +1);
	    	}else{
	    		map.put(s, 1);
	    	}
		}
	    
	    //输出单词统计结果
	    Set<String> keys=map.keySet();
	    for (String key : keys) {
	    	int num=map.get(key);
	    	if(num > 2)
	    		System.out.println("count("+key+")=" + num);
		}
	    
	}
	
	//去除重复的记录  http://simplehumn.iteye.com/blog/812064
	public static String str_unique(String str) {  
		String regEx = "[\\s',?.!\\-]+"; // 正则表达式规则,至少1个空格
	    String[] a=str.split(regEx);//分割字符串
	    
	    // array_unique  
	    List<String> list = new LinkedList<String>();  
	    for(int i = 0; i < a.length; i++) {  
	        if(!list.contains(a[i])) {  
	            list.add(a[i]);
	        }
	    }
	    String[] arr= (String[])list.toArray(new String[list.size()]);
	    StringBuilder sb=new StringBuilder();
	    for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+" ");
		}
	    
	    return sb.toString();
	}
}
