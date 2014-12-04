<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<header>
	</header>
<body>

<a href ="books.do">查看books例子</a><br/>
<a href ="msg/queryMsg.do"> 查看消息</a>
 <form di="form" method="post" action="msg/sendMsg.do">
			<input type="text" name="name" value="${name}">
			<input type="text" name="content" ><br/>
<input type="submit" name="" value="发送" >
</body>
</html>
