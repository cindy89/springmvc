<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<style type="text/css">
	#box{width:65%;background:#f9f9f9;padding:20px 0;}
	#box h3{background:#ccc;}
	#box table{width:85%;}
	#box,#box table{margin:0 auto;}
	#box .op,#box h3{text-align:center;}
</style>
</head>
<body>
	<div id="box">
		<h3>用户列表</h3>
		<form action="#" id="form1" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th></th>
				<th>用户名</th>
				<th>密码</th>
				<th>邮编</th>
				<th>地址</th>
				<th>电话</th>
				<th>邮箱</th>
			</tr>
			<c:forEach items="${userlist }" var="user" varStatus="vs">
			<tr>
					<td><input type="checkbox" id="id+${user.id }" name="userid" value="${user.id }"></td>
					<td>${user.name }</td>
					<td>${user.pwd }</td>
					<td>${user.zip }</td>
					<td>${user.addr }</td>
					<td>${user.phone }</td>
					<td>${user.email }</td>
			</tr>
			</c:forEach>
		</table>
		<div class="op">
			<input type="button" value="增加" onclick="window.location.href='addform.action'"/>
			<input type="button" value="删除" onclick="deleteUser();">
		</div>
		</form>
	</div>
	<script type="text/javascript">
		function deleteUser(){
			var idarr=document.getElementsByName("userid");
			var ids="";
			for(var i=0;i<idarr.length;i++){
				if(idarr[i].checked){
					ids+=idarr[i].value+",";
				}
			}
			document.getElementById("form1").action="delete.action?id="+ids;
			document.getElementById("form1").submit();
		}
</script>
</body>
</html>