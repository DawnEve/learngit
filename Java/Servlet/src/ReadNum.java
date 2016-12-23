import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadNum extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");//设定输出编码
		 
		//读取文件
		//1.获得文件
		String filename="f:\\test.txt";
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		
		//读取一行
		String num=br.readLine();//读取第一行
		br.close();
		fr.close();
		
		//获取输出流
		PrintWriter out=res.getWriter();
		out.println(num);
		
		//访问一次，计数器增加1
		FileWriter fw=new FileWriter(filename);
		BufferedWriter bw=new BufferedWriter(fw);
		int num2=Integer.parseInt(num)+1;
//		bw.write(""+num2);
		bw.write(String.valueOf(num2));
		bw.close();
		fw.close();
		
	}

}
