<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p align="center"> <%= request.getAttribute("msg") %> </p>
<form align="center" action="logincheck" method="post"> 
<table align="center">
<tr>
<td>
username:
</td>
<td>
<input type="text" name="userid" length=25/>

</td>
</tr>
<tr>
<td> password:</td>
<td><input type="password" name="password" length=25 /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="login" /></td>
</tr>
</table>
</form>

</body>
</html>