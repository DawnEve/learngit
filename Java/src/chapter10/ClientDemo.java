package chapter10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		demo1();
	}
	static void demo1() throws UnknownHostException, IOException{
		//创建socket，便于连接到服务器
//		Socket sc=new Socket("192.168.1.100",8082);
//		Socket sc=new Socket("127.0.0.1",8082);
		Socket sc=new Socket("localhost",8082);
		//获取当前流
		DataInputStream in=new DataInputStream(sc.getInputStream());//获取当前输入流
		DataOutputStream out=new DataOutputStream(sc.getOutputStream());//获取当前输出流
		
		//向服务器发送消息
		out.writeUTF("hello,客户端信息");
		//读取服务器返回的信息
		System.out.println(in.readUTF());
		
		//关闭流
		in.close();
		out.close();
		//关闭此Socket连接
		sc.close();
	}
}
