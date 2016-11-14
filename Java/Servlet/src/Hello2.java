import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>Hello abc2222222222!</BODY></HTML>");
	}
}