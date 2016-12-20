import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Hello6 extends HttpServlet {

	/** 
	 * session操作 db判断
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException
	{
		// 执行必需的初始化
		System.out.println("Hello World, init~");
	}
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		//get方式获取用户名和密码
		String usr=req.getParameter("user");
		String psw=req.getParameter("pass");

		
		try {
			//1.连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		
			//3.获取statement
			Statement stmt=conn.createStatement();
			stmt.executeQuery("use think;");
			ResultSet rs = stmt.executeQuery("select * from think_user where user='"+usr+"' limit 1;");//结果集
			
			//4.输出结果
			//获取输出流
			PrintWriter out = res.getWriter();
			
			while(rs.next()){
				String psw_db=rs.getString(3); //此方法比较高效，第一列编号是1，不是0。
				String usr_id=rs.getString(1); 
				//System.out.println("psw_db="+psw_db);
				//System.out.println("psw="+psw);
				
				//4.1.判断是否成功登录
				if(psw.equals(psw_db)){
					String str=usr + " 登录成功!";
					out.println(str + "<br />");
					System.out.println(str+"\n");
					
					//4.2登录成功则写入session
					//获取session
					HttpSession hs=req.getSession(true);
					//设置session时间.默认是30min。
					hs.setMaxInactiveInterval(10);//10s 
					//设置session内容
					hs.setAttribute("pass","ok");
					hs.setAttribute("usr",usr);
					hs.setAttribute("usr_id",usr_id);
					
					return;
				}else{
					String str="用户名或密码错误！";
					System.out.println(str);
					out.println(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
