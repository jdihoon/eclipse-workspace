<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="insert.do">
	
		��&nbsp;&nbsp;&nbsp;ȣ : <input type="text" name="bId" readonly /> <br />
		�ۼ��� : <input type="text" name="bName" /> <br />
		��&nbsp;&nbsp;&nbsp;�� : <input type="text" name="bTitle" /> <br />
		��&nbsp;&nbsp;&nbsp;�� : <textarea name="bContent" cols="40" rows="10"></textarea> <br />
		�ۼ��� : <input type="date" name="bDate" readonly /> <br />
		������ : <input type="text" name="bHit" readonly /> <br />
		��&nbsp;&nbsp;&nbsp;�� : <input type="text" name="bStep" readonly /> <br />
		�ε�Ʈ : <input type="text" name="bIndent" readonly /> <br />
		
		<input type="submit" value="�Է�"> &nbsp;&nbsp;&nbsp;
		<input type="reset" value="���"> &nbsp;&nbsp;&nbsp;
		<input type="button" value="��Ϻ���" onclick="location.href='selectAll.do'">
		
	</form>
</body>
</html>