<%--
  Created by IntelliJ IDEA.
  User: Lenovo™
  Date: 10/14/2020
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="navbar.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Struts2 JSP Example</title>
</head>
<body>

<h1>Add New User</h1>
<br>
<s:property value="message"/>
<br>
<s:form action="save_user">
    <s:textfield name="name" label="Name"/>
    <s:textfield name="username" label="Username"/>
    <s:textfield name="user_role" label="User Role"/>
    <s:password name="password" label="Password"/>
    <s:submit value="Register"></s:submit>
</s:form>


</body>
</html>
