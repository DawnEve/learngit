package com.mio.mysql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.jdbc.Connection;

@WebServlet("/dbdemo1")
public class DBDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		//get方式获取用户名和密码
		String username=req.getParameter("username");
		String passwd=req.getParameter("passwd");
		if(null==passwd) {
			passwd="";
		}
		System.out.printf("username:%s, passwd:%s\n", username, passwd);
		
		Connection conn=null;
		Statement stmt=null;
		try {
			//1.连接数据库
			//Class clazz=Class.forName("com.mysql.jdbc.Driver");
			//2.获得链接
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			//3.获取statement
			stmt=conn.createStatement();
			//4.执行查询
			stmt.executeQuery("use mysql;");
			ResultSet rs=stmt.executeQuery("select * from user where user='"+username+"' limit 1;");
			//5.输出结果
			PrintWriter out = resp.getWriter();
			while(rs.next()) {
				for(int i=1; i<3; i++) { //从1开始计数
					System.out.printf("> rs[%d]: %s\n", i, rs.getString(i));
				}
				String passwd_db=rs.getString(3); //获取第n列，1-based
				String userid=rs.getString(1);
				System.out.println(rs); //com.mysql.jdbc.JDBC42ResultSet@498fff66
				
				//6.判断是否登陆成功
				//获取session
				HttpSession hs=req.getSession();

				if(passwd.equals(passwd_db)) {
					//显示消息
					String msg=username+" 登录成功！";
					out.println(msg+"<br>");
					System.out.println(msg+"\n");
					
					//7.登录成功则写入session
					hs.setMaxInactiveInterval(10); //10s
					//设置session内容
					hs.setAttribute("pass", "ok");
					hs.setAttribute("username", username);
					hs.setAttribute("userid", userid);
				}else {
					String msg="用户名或密码错误！";
					System.out.println(msg);
					out.println(msg);
				}
				
				//8.遍历显示session 到网页
				Enumeration<String> enu = hs.getAttributeNames();
				out.println("<hr><b>Session key-values:</b>");
				while(enu.hasMoreElements()) {
					String key=enu.nextElement();
					String value=(String) hs.getAttribute(key);
					out.printf("<p>%s: %s</p>", key, value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 关闭资源，需要在用一次try catch
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
