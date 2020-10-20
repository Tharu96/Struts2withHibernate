<%--
  Created by IntelliJ IDEA.
  User: Lenovo™
  Date: 10/14/2020
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="navbar.jsp"></jsp:include>
<hr/>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>Welcome, <s:property value="username"/></h3>

<h4>Admin Details:</h4>

<fieldset>
    <h5>User ID : <s:property value="user.user_id"/></h5><br/>
    <h5>Name : <s:property value="user.name"/></h5><br/>
    <h5>Username: <s:property value="user.username"/></h5><br/>
    <h5>Password : <s:property value="user.password"/></h5><br/>

</fieldset>

<a href="user_admin">User Admin</a>|


