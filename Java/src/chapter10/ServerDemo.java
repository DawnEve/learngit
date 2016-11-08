package chapter10;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
//		demo1();
		demo2();
	}
	
	/**
	 * 使用DataInputStream和DataOutputStream包装流后，可以直接传递utf字符。
	 * @throws IOException
	 */
	private static void demo2() throws IOException {
		int count=0;
		int port=8082;
		ServerSocket server=new ServerSocket(port);
		System.out.println("正在监听端口："+port);
		//服务器开始循环监听
		while(true){
			//接收到客户端连接请求，如有连接请求，则返回对应的Socket对象
			Socket socket=server.accept();
			//获取当前流
			DataInputStream input =new DataInputStream(socket.getInputStream());//获取当前输入流
			DataOutputStream output=new DataOutputStream(socket.getOutputStream());//获取输出流
			
			//打印客户端信息
			System.out.println("第"+(++count)+"个用户");
			System.out.println("客户端IP:" + socket.getInetAddress());
			System.out.println("本地端口号："+ socket.getLocalPort());
			System.out.println("客户端info："+ input.readUTF());
			
			//向客户端写入
			output.writeUTF("hello,from server."+ (new Date()));
			//关闭流
			input.close();
			socket.close();
			System.out.println("================");
		}
	}


	/**
	//原始版本，不好用
	 * 接收不到字符，只有字节
	 * @throws IOException
	 */
	static void demo1()  throws IOException{
		int count=0;
		int port=8082;
		ServerSocket server=new ServerSocket(port);
		System.out.println("正在监听端口："+port);
		//服务器开始循环监听
		while(true){
			//接收到客户端连接请求，如有连接请求，则返回对应的Socket对象
			Socket socket=server.accept();
			//获取当前输入流
			InputStream input=socket.getInputStream();
			OutputStream output=new BufferedOutputStream(socket.getOutputStream());
			
			//打印客户端信息
			System.out.println("第"+(++count)+"个用户");
			System.out.println("客户端IP:" + socket.getInetAddress());
			System.out.println("本地端口号："+ socket.getLocalPort());
			System.out.println("客户端info："+ input.read());
			//向客户端写入
			output.write("hello,from server".getBytes());
			//关闭流
			input.close();
//			output.close();
			socket.close();
//			break;
			System.out.println("================");
		}
//		server.close();
	}

}
