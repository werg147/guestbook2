<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "java.util.List" %>
<%@ page import = "com.javaex.vo.GuestVo" %>

<!-- GuestController forward > guestList -->
<%  //형변환 object -> List<GuestVo>
	List<GuestVo> guestList = (List<GuestVo>)request.getAttribute("gList");
	//System.out.println(guestList);
%>


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
	
	<%for(int i=0; i<guestList.size(); i++){ %>
		<table border = "1" width="500">
			<tr>
				<td><%=guestList.get(i).getNo() %></td>
				<td><%=guestList.get(i).getName() %></td>
				<td><%=guestList.get(i).getRegDate() %></td>
				<td><a href="/guestbook2/gbc?action=delform&no=<%=guestList.get(i).getNo() %>">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4><%=guestList.get(i).getContent() %></td>
			</tr>
		</table>
		<br>
	<%} %>

</body>
</html>