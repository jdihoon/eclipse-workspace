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
	
		번&nbsp;&nbsp;&nbsp;호 : <input type="text" name="bId" readonly /> <br />
		작성자 : <input type="text" name="bName" /> <br />
		제&nbsp;&nbsp;&nbsp;목 : <input type="text" name="bTitle" /> <br />
		내&nbsp;&nbsp;&nbsp;용 : <textarea name="bContent" cols="40" rows="10"></textarea> <br />
		작성일 : <input type="date" name="bDate" readonly /> <br />
		읽은수 : <input type="text" name="bHit" readonly /> <br />
		스&nbsp;&nbsp;&nbsp;텝 : <input type="text" name="bStep" readonly /> <br />
		인덴트 : <input type="text" name="bIndent" readonly /> <br />
		
		<input type="submit" value="입력"> &nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소"> &nbsp;&nbsp;&nbsp;
		<input type="button" value="목록보기" onclick="location.href='selectAll.do'">
		
	</form>
</body>
</html>