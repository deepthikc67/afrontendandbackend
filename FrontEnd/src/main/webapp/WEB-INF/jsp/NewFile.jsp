    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.niit.Model.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Category> clist=(List<Category>)request.getAttribute("categoryList");
for(Category c:clist){
	
	out.println();
}
%>

<c:forEach items="${categoryList}"  var="ccc">
<c:out value="${ccc}"></c:out>
<%out.println("ccc");%></c:forEach>

</body>
</html>