package com.mio.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 提前新建一个文件 F:/test.txt 里面写上1
@WebServlet("/visitNumber")
public class VisitNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charSet=utf8");//设定输出编码
		
		//1.获取文件流
		String filename="f:\\test.txt";
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		
		//2.读取第一行
		String str1=br.readLine();
		//3.关闭文件流
		br.close();
		fr.close();
		
		//3.获取输出流
		PrintWriter out=resp.getWriter();
		out.println(str1);
		
		//4.访问一次，计数器增加1
		FileWriter fw=new FileWriter(filename);
		BufferedWriter bw=new BufferedWriter(fw);
		int num2=Integer.parseInt(str1)+1;
		bw.write(""+num2);
		bw.close();
		fw.close();
	}
}