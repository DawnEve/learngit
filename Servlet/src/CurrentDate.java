import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

public class CurrentDate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		
		//当前时间
		Date date=new Date();
		out.println("1.当前日期和时间："+date.toString());
		
		//java的时间戳
		out.println("<br>2.java时间戳 （单位：ms）："+date.getTime()+", 需要缩小1000倍后和php一样:"+ date.getTime()/1000);
		out.println("<br>(php[10位]:1482674513)<br>");
		
		//格式化显示
		SimpleDateFormat ft = 
				new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss E a");
		out.println("3.格式化后："+ft.format(date));
		
		
	}
}