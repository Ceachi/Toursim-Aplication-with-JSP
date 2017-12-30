<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	 <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
	
	<%	
			// spunei browserului sa nu memoreze nimic in cache, sa rezolvi problema cu back
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache"); // same thing, but for HTTP 1.0
			 response.setHeader("Expires", "0");//Proxies
			if(session.getAttribute("username") == null) {
				response.sendRedirect("loginView.jsp");
			}
	%>

 
	Countries:
	<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>id</th>
          <th>Name</th>
       </tr>
       <c:forEach items="${regionList}" var="region" >
          <tr>
             <td>${region.id}</td>
             <td>${region.name}</td>
             <td>
                <a href="editProduct?code=${region.id}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${region.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
    
	
	
</body>
</html>