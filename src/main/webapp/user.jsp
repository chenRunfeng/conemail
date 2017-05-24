<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户</title>
</head>
<body>
<table cellspacing="0" border="1" class="table1">
<thead>
<tr>
<th width="300">姓名</th>
<th width="300">身份证号</th>
<th width="300">邮件</th>
</tr>
</thead>
<tbody>
<c:forEach var="u" items="${requestScope.userlist}">
<tr>
<td align="center">${u.user_id}</td>
<td align="center">${u.user_name}</td>
<td align="center">${u.email}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>