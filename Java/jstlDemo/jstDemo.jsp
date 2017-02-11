<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
           <title>第一个JST程序</title>
    </head>
    <body>
    <% String name="wjl's book000"; 
    	request.setAttribute("name", name);//必须放到4个变量之一中才行
    	request.setAttribute("age", 100);
    	
    %>
    <c:out value="name:"></c:out><hr>
    <c:out value="${name}"></c:out><hr>
    ${age  }
    </body>
</html>