<%-- <%@page import="com.javalec.ex.dto.BDto"%>
<%@page import="java.util.ArrayList"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding=0 cellspacing="0" border="1">
	
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>읽은 수</th>
		</tr>
		
		<%-- <%
			try {
				ArrayList<BDto> dtos = ( ArrayList<BDto> ) request.getAttribute("selectAll");
			
				for(BDto dto : dtos) {
		%>
		<tr>	
			<td><%= dto.getbId() %></td>
			<td><%= dto.getbName() %></td>
			<td><a href="select.do?bId=<%= dto.getbId() %>"><%= dto.getbTitle() %></a></td>
			<td><%= dto.getbHit() %></td>
		</tr>	
		<%
				}
			} catch(NullPointerException e) {
				e.printStackTrace();
			}	
		%> --%>
		<c:forEach var="dto" items="${requestScope.selectAll}">
		
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td><a href="select.do?bId=${dto.bId}">${dto.bTitle}</a></td>
				<td>${dto.bHit}</td>
			</tr>		
			
		</c:forEach>
		<tr align="center">
			<td colspan="4"><a href="write.jsp">글작성</a>
		</tr>
	
	</table>

</body>
</html>