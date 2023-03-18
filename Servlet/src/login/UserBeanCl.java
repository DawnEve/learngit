package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserBeanCl {
	//能用私有的绝不用公有
	//业务逻辑
	private Connection conn=null;
//	private Statement stmt=null;
	private PreparedStatement  pstmt=null;
	private Statement  stmt=null;
	private ResultSet rs=null;
	private int totalPage=0;//共多少页
	private int currentPage=0;//当前页
	
	//返回总页码
	public int getTotalPage(){
		return this.totalPage;
	}
	//返回当前页码
	public int getCurrentPage(){
		return this.currentPage;
	}
	
	//验证用户
	public boolean checkUser(String u, String p){
		boolean b=false;
		try {
			//得到链接
			ConnDB db=new ConnDB();
			conn=db.getConn();
			//查询密码
			pstmt=conn.prepareStatement("select passwd from user where user=?;");
			pstmt.setString(1, u);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String dbPasswd=rs.getString(1);
				//比较密码是否相同
				if(dbPasswd.equals(p)){
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			this.close();
		}
		
		return b;
	}
	
	
	//分页显示
	public ArrayList getResultByPage(int currentPage,int pageSize){
		ArrayList al=new ArrayList();
		//分页设置
		//int pageSize=5;//一页多少条-设置
		int totalRow=0;//一共多少行？查表
		int totalPage=0;//一共多少页-计算
		//int currentPage=1;//get传过来
		
		try {
			//获取链接
			ConnDB db=new ConnDB();
			conn=db.getConn();
			
			//3.获取statement
			stmt=conn.createStatement();
			stmt.executeQuery("use think;");
			//获取总页码
			rs=stmt.executeQuery("select count(*) from user;");
			if(rs.next()){
				totalRow=rs.getInt(1);
			}
			if(rs!=null){
				rs.close();
			}

			//计算总页码
			if(totalRow%pageSize==0){
				totalPage=totalRow/pageSize;
			}else{
				totalPage=totalRow/pageSize+1;
			}
			
			//获得当前页码
			if(currentPage<1)currentPage=1;
			if(currentPage>totalPage)currentPage=totalPage;
			//传递过滤过的值
			this.totalPage=totalPage;
			this.currentPage=currentPage;

			int start=(currentPage-1)*pageSize;
			rs = stmt.executeQuery("select * from user limit "+start+","+pageSize);//结果集
			
			//4.输出结果
			while(rs.next()){
				//第一步：将rs每一条记录封装到UserBean中
				UserBean ub=new UserBean();
				
//				ub.setId(rs.getInt(1));
				ub.setId(rs.getInt("id"));
				//ub.setUser(rs.getString(2));
				//ub.setUser("user");
				ub.setUser(rs.getString("user"));
				ub.setPasswd(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setAdd_time(rs.getInt(5));
				//第二步：将UserBean ub放入到ArrayList
				al.add(ub);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			this.close();
		}
		
		return al;
	}
	
	
	
	//关闭资源
	public void close(){
		try {
			if(rs!=null) {
				rs.close();
				rs=null;
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(pstmt!=null){
				pstmt.close();
				pstmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
