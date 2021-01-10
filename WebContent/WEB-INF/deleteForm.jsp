<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//list.jsp 에서 삭제버튼을 누르면 > no값 파라미터로 읽기
	int no = Integer.parseInt(request.getParameter("no"));
	//주소String으로 읽히는 no값을 int에 담기

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook2/gbc" method="get">
		비밀번호
		<input type="text" name="password" value="">
		<button type="sybmit">확인</button> <br>
		<input type="hidden" name="no" value="<%=no%>">
		<!-- action값!! -->
		<input type="hidden" name="action" value="delete">
    </form>
    
    <a href="/guestbook2/gbc?action=list">메인으로 돌아가기</a>
    
</body>
</html>