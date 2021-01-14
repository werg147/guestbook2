<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook2/gbc" method="get">
		<table border = "1">
		 	<tr>
		 		<td>이름</td>
		 		<td><input type="text" name="name" value=""></td>
		 		<td>비밀번호</td>
		 		<td><input type="text" name="password" value=""></td>
		 	</tr>
		 	<tr>
		 		<td colspan=4><textarea name="content"></textarea></td> <!-- name추가 잊어서 content null오류 떴었음 -->
		 	</tr>
		 	<tr>
		 		<td colspan=4><button type="submit">확인</button></td>
		 	</tr>
		</table>
		<input type="hidden" name="action" value="insert">
	</form>
	
	<!-- request.getAttribute("gList"); -->
	<c:forEach items="${gList}" var="gList">
		<table border = "1" width="500">
			<tr>
				<td>${gList.no}</td>
				<td>${gList.name}</td>
				<td>${gList.regDate}</td>
				<td><a href="/guestbook2/gbc?action=delform&no=${gList.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>${gList.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>

</body>
</html>