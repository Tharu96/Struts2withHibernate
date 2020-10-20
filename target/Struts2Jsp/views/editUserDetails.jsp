<jsp:include page="navbar.jsp"></jsp:include>
<hr/>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>Edit User Details <s:property value="username"/></h3>

<h4>User Details:</h4>

<br> <s:property value="message"/> <br>
<s:form action="edit_user">
    <pre>
    <b>User Id:  </b><input type="text" name="user_id" value='<s:property value="user.user_id"/>'>
    <b>Name:     </b><input type="text" name="name" value='<s:property value="user.name"/>'>
    <b>Username: </b><input type="text" name="username" value='<s:property value="user.username"/>'>
    <b>Password: </b><input type="text" name="password" value='<s:property value="user.password"/>'>
    <b>User Role:</b><input type="text" name="user_role" value='<s:property value="user.user_role"/>'>

    <s:submit value="update"></s:submit>
    </pre>
</s:form>
