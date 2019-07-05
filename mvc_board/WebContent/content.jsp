<%@page import="com.javalec.ex.dto.BDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" action="update.do">
	
		번&nbsp;&nbsp;&nbsp;호 : <input type="text" name="bId" readonly value="${select.bId}" /> <br />
		작성자 : <input type="text" name="bName" value="${select.bName}"/> <br />
		제&nbsp;&nbsp;&nbsp;목 : <input type="text" name="bTitle" value="${select.bTitle}" /> <br />
		내&nbsp;&nbsp;&nbsp;용 : <textarea name="bContent" cols="40" rows="10">${select.bContent}</textarea> <br />
		작성일 : <input type="date" name="bDate" readonly value="${select.bDate}"/> <br />
		읽은수 : <input type="text" name="bHit" readonly value="${select.bHit}" /> <br />
		스&nbsp;&nbsp;&nbsp;텝 : <input type="text" name="bStep" readonly value="${select.bStep}"/> <br />
		인덴트 : <input type="text" name="bIndent" readonly value="${select.bIndent}" /> <br />
		
		<input type="button" value="목록보기" onclick="location.href='selectAll.do'" /> &nbsp;&nbsp;&nbsp;
		<input type="submit" value="수정하기" /> &nbsp;&nbsp;&nbsp;
		<input type="button" value="삭제하기" onclick="location.href='delete.do?bId=${select.bId}'" />
	
	</form>
</body>
</html>