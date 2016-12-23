<%@ page contentType="text/html; charset=UTF-8" %>

<script>
function check(){
	var num1=document.forms[0].num1.value;
	var num2=document.forms[0].num2.value;
	var flag=document.forms[0].flag.value;
	
	//如果num1或num2为空，则提示输入，并阻止提交
	if(num1=="" || num2==""){
		alert("不能留空！请输入数字");
		if(num1==""){
			document.forms[0].num1.focus();
		}else{
			document.forms[0].num2.focus();
		}
		return false;
	}
	
	//如果不是数字也不行
	if(isNaN(num1) || isNaN(num2)){
		alert("不是数字！请输入数字");
		if(isNaN(num1)){
			document.forms[0].num1.focus();
		}else{
			document.forms[0].num2.focus();
		}
		return false;
	}
}
</script>


<%
//获取参数
String s1=request.getParameter("num1");
String s2=request.getParameter("num2");
String flag=request.getParameter("flag");

if(s1==null)s1="0";
if(s2==null)s2="0";
if(flag==null)flag="1";

int n1=Integer.parseInt(s1);
int n2=Integer.parseInt(s2);
int n=0;

if(flag.equals("1")){n=n1+n2;}
if(flag.equals("2")){n=n1-n2;}
if(flag.equals("3")){n=n1*n2;}
if(flag.equals("4")){n=n1/n2;}
%>
<h1>jsp版计算器</h1>
<form action="" method="get">
	第一个数字 <input type="text" name=num1 value="<%=n1 %>"><br>
	操作符 <select name=flag>
		<option value='1' <% if(flag.equals("1")) out.println("selected"); %>>+</option>
		<option value='2' <% if(flag.equals("2")) out.println("selected"); %>>-</option>
		<option value='3' <% if(flag.equals("3")) out.println("selected"); %>>*</option>
		<option value='4' <% if(flag.equals("4")) out.println("selected"); %>>/</option>
	</select><br>
	第二个数字 <input type="text" name=num2 value="<%=n2 %>"><br>
	<input type="submit" value="计算" onclick="return check()">
</form>
<hr />

<%
String[] flagCN={"加","减","乘","除"};
out.println(s1+flagCN[Integer.parseInt(flag)-1]+s2+" 结果是： "+n);

//http://localhost:8080/myjsp/myCalc.jsp?num1=10&num2=2
//10与2的和是12

//http://localhost:8080/myjsp/myCalc.jsp?num1=230&flag=1&num2=23
%>