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
	
		��&nbsp;&nbsp;&nbsp;ȣ : <input type="text" name="bId" readonly value="${select.bId}" /> <br />
		�ۼ��� : <input type="text" name="bName" value="${select.bName}"/> <br />
		��&nbsp;&nbsp;&nbsp;�� : <input type="text" name="bTitle" value="${select.bTitle}" /> <br />
		��&nbsp;&nbsp;&nbsp;�� : <textarea name="bContent" cols="40" rows="10">${select.bContent}</textarea> <br />
		�ۼ��� : <input type="date" name="bDate" readonly value="${select.bDate}"/> <br />
		������ : <input type="text" name="bHit" readonly value="${select.bHit}" /> <br />
		��&nbsp;&nbsp;&nbsp;�� : <input type="text" name="bStep" readonly value="${select.bStep}"/> <br />
		�ε�Ʈ : <input type="text" name="bIndent" readonly value="${select.bIndent}" /> <br />
		
		<input type="button" value="��Ϻ���" onclick="location.href='selectAll.do'" /> &nbsp;&nbsp;&nbsp;
		<input type="submit" value="�����ϱ�" /> &nbsp;&nbsp;&nbsp;
		<input type="button" value="�����ϱ�" onclick="location.href='delete.do?bId=${select.bId}'" />
	
	</form>
</body>
</html>