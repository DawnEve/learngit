package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

public class Wel extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		
		//1.判断是否合法
		HttpSession hs=req.getSession(true);
		String val=(String) hs.getAttribute("uname");
		if(val==null){
			//非法登录
			res.sendRedirect("login");//重定向到某个url
			return;
		}
		
		// 实际的逻辑是在这里 用户信息
		PrintWriter out = res.getWriter();
		out.println("<h1>" + "保密内容[用户：" + val +"]</h1>");
		
		
		
		
		//分页设置
		int pageSize=5;//一页多少条-设置
		int currentPage=1;//当前页
		int totalPage=0;//总页码，计算得
		String gcurrentPage=req.getParameter("page");
		if(gcurrentPage != null){
			currentPage=Integer.parseInt(gcurrentPage);
		}
		
		//调用UserBeanCl，获取UserBean对象集合
		UserBeanCl ubc=new UserBeanCl();
		ArrayList al=ubc.getResultByPage(currentPage, pageSize);
		totalPage=ubc.getTotalPage();
		currentPage=ubc.getCurrentPage();
		
		//4.输出结果
		//获取输出流
		out.println("<table border='1'>");
		out.println("<tr><td>id</td><td>user</td><td>passwd</td><td>email</td><td>passwd</td><td>add_time</td></tr>");
		for(int i=0;i<al.size();i++){
			UserBean ub=(UserBean)al.get(i);

			out.println("<tr><td>"+ub.getId()+
					"</td><td>"+ub.getUser()+
					"</td><td>"+ub.getPasswd()+
					"</td><td>"+ub.getEmail()+
					"</td><td>"+ub.getPasswd()+
					"</td><td>"+ub.getAdd_time()+
					"</td></tr>");
		}
		out.println("</table>");
		
		//输出分页按钮
		if(currentPage>1){
			out.print(" <a href='?page="+(currentPage-1)+"'>上一页</a> ");
		}
		//如果太多，怎么显示分页按钮呢？模仿网易博客
		for(int i=1;i<=totalPage;i++){
			if(i!=currentPage){
				out.print(" <a href='?page="+i+"'>"+i+"</a> ");
			}else{
				out.print(i);
			}
		}
		if(currentPage<totalPage){
			out.print(" <a href='?page="+(currentPage+1)+"'>下一页</a> ");
		}
		
	}
}
