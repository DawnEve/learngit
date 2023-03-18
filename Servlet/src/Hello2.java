import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		String par = request.getParameter("par1");
		
		
		//这地方有什么不同吗？
		ServletContext context = getServletContext( );
		ServletContext context2 = request.getServletContext( );
		System.out.println(context.toString());
		System.out.println(context2.toString());
		System.out.println(context.equals(context2));//true


		if (par == null || par.equals("")){
			//System.out.println("error 11aa110");
			
			
			// 通过 Throwable 参数记录版本
			context.log("No message received:",
					new IllegalStateException("Missing parameter11aa110"));
		}else{
			System.out.println("error 11aa111");
			context.log("Here is the visitor's message11aa111: " + par);
		}
		context.log("11aathis is a log with nothing wrong."); 
	      
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>Hello abc2222222223!</BODY></HTML>");
	}
	/*
ServletContext 把它的文本消息记录到 Servlet 容器的日志文件中。
对于 Tomcat，这些日志可以在 <Tomcat-installation-directory>/logs 目录中找到。

这些日志文件确实对新出现的错误或问题的频率给出指示。
正因为如此，建议在通常不会发生的异常的 catch 子句中使用 log() 函数。
	 * */
}