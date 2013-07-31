<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户表单</title>
<style type="text/css">
	#box{width:65%;background:#f9f9f9;padding:20px 0;}
	#box h3{background:#ccc;}
	#box table{width:55%;}
	#box,#box table{margin:0 auto;}
	#box .op,#box h3{text-align:center;}
</style>
</head>
<body>
	<div id="box">
		<h3>添加用户</h3>
		<form action="add.action" method="post">
		<table border="1" cellspacing="0" cellpadding="0">
<!-- 			<tr> -->
<!-- 				<td><input type="text" id="user.id" name="user.id" readonly="readonly"></td> -->
<!-- 			</tr> -->
			<tr>
				<td>用户名:<input type="text" id="user.name" name="user.name"/></td>
			</tr>
			<tr>
				<td>密码:<input type="text" id="user.pwd" name="user.pwd"/></td>				
			</tr>
			<tr>
				<td>邮编:<input type="text" id="user.zip" name="user.zip"/></td>
			</tr>
			<tr>
				<td>地址:<input type="text" id="user.addr" name="user.addr"/></td>
			</tr>
			<tr>
				<td>电话:<input type="text" id="user.phone" name="user.phone"/></td>
			</tr>
			<tr>
				<td>邮箱:<input type="text" id="user.email" name="user.email"></td>
			</tr>
		</table>
		<div class="op">
			<input type="submit" id="submit" value="增加"/>
		</div>
		</form>
	</div>
</body>
</html>