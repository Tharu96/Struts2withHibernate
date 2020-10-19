<jsp:include page="navbar.jsp"></jsp:include>
<hr/>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3>Edit User Details <s:property value="username"/></h3>

<h4>User Details:</h4>

<fieldset>
    <h5>Name : <s:property value="user.name"/></h5><br/>
    <h5>Username: <s:property value="user.username"/></h5><br/>
    <h5>Password : <s:property value="user.password"/></h5><br/>


</fieldset>
<s:form action="editUser">
    <s:textfield value="<% user.user_id %>" name="user.user_id" label="User Id"/>
    <s:textfield value="user.name" name="user.name" label="Name"/>
    <s:textfield value="user.username" name="username" label="Username"/>
    <s:password value="user.password" name="userpass" label="Password"/>
    <s:textfield value="user.user_role" name="user_role" label="User Role"/>
    <s:submit value="update"></s:submit>
</s:form>
