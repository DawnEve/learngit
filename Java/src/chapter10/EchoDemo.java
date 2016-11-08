package chapter10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoDemo {
	private static PrintStream out;
/**
 * 写一个简单的web服务器
 * http://www.cnblogs.com/wangrui-techbolg/archive/2013/03/10/2953108.html
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		demo1();
	}
	
	private static void demo1() throws IOException {
		int count=0;
		int port=8082;
		ServerSocket server=new ServerSocket(port);
		System.out.println("正在监听端口："+port);
		//服务器开始循环监听
		while(true){
			//接收到客户端连接请求，如有连接请求，则返回对应的Socket对象
			Socket socket=server.accept();
			//获取当前流
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
			
			//打印客户端信息
			System.out.println("第"+(++count)+"个用户");
			System.out.println("客户端IP:" + socket.getInetAddress());
			System.out.println("本地端口号："+ socket.getLocalPort());
			
			//获取内容
			String htmlName=parse(input);//"bb.txt";
			byte[] content=getContent(htmlName);
			
			//向客户端写入
			echo(socket,content);//向客户端写入文件
			
			//关闭流
			input.close();
			socket.close();
			System.out.println("================");
		}
	}

	private static byte[] getContent(String htmlName) throws IOException {
		File file=new File("dustbin"+File.separator+htmlName);
		if (!file.exists()) {
		    sendError(404, "File Not Found");
		    return null;
		}
		FileInputStream fis=new FileInputStream(file);
		byte[] content=new byte[(int) file.length()];
		
		fis.read(content);
		fis.close();
		return content;
	}
	
	

	private static String parse(BufferedReader input) throws IOException {
		String inputContent = input.readLine();
		if (inputContent == null || inputContent.length() == 0) {
			sendError(400, "Client invoke error");
			return null;
		}
		
		// 分析客户请求的HTTP信息，分析出到底想访问哪个文件，
		// 发过来的HTTP请求应该是三部分。
		String request[] = inputContent.split(" ");
		if (request.length != 3) {
			sendError(400, "Client invoke error");
			return null;
		}
		for (int i = 0; i < request.length; i++) {
			System.out.println(request[i]);
		}
		
		// 第一部分是请求的方法
		String method = request[0];
		// 第二部分是请求的文件名
		String fileName = request[1];
		// 第三部分是HTTP版本号
		String httpVersion = request[2];
		 //获取线程名字
        String thread=", thread: "+Thread.currentThread().toString();
        
		System.out.println("Method: " + method + ", file name: " + fileName + ", HTTP version: " + httpVersion+thread);
		return fileName;
	}

    public static void sendError(int errNum, String errMsg) throws IOException {
//		PrintStream  out=new PrintStream(socket.getOutputStream());
		out.println("HTTP/1.0 " + errNum + " " + errMsg);
		
		out.println("Content-length: " + errMsg.length());
		out.println();
		out.write(errMsg.getBytes());
		out.flush();
		out.close();
	}

	private static void echo(Socket socket, byte[] content) throws IOException {
		//
		PrintStream  out=new PrintStream(socket.getOutputStream());
		out.println("HTTP/1.0 200 sendFile");
		out.println("Content-length: " + content.length);
		out.println();
		out.write(content);
		out.flush();
		out.close();
	}
}
