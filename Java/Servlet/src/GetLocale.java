import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetLocale extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Locale locale =request.getLocale();
		String language=locale.getLanguage();//语言
		String country=locale.getCountry();//国家

		String date = DateFormat.getDateTimeInstance(
                DateFormat.FULL, 
                DateFormat.SHORT, 
                locale).format(new Date( ));//本地化日期

		//输出
		PrintWriter out=response.getWriter();
		out.println("language:"+language+"<br>");
		out.println("country:"+country+"<br>");
		
		out.println("date:"+date+"<br>");
		//language:zh
		//country:CN
	}
	
	

}
