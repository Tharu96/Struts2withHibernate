<%--
  Created by IntelliJ IDEA.
  User: Lenovo™
  Date: 10/15/2020
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="navbar.jsp"></jsp:include>
<hr/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Manage Users</title>


</head>
<body>
<h3>Manage Users</h3>

<s:if test="users_list.size() > 0">
    <div class="content">
        <table class="userTable" cellpadding="5px">
            <tr class="even">
                <th>User ID</th>
                <th>Name</th>
                <th>Username</th>
                <th>Password</th>
                <th>User Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <s:iterator value="users_list" status="userStatus">
                <tr
                        class="<s:if test="#userStatus.odd == true ">odd</s:if> <s:else>even</s:else>">
                    <td><s:property value="user_id" /></td>
                    <td><s:property value="name" /></td>
                    <td><s:property value="username" /></td>
                    <td><s:property value="password" /></td>
                    <td><s:property value="user_role" /></td>
                    <td>
                        <s:url id="editURL" action="loadEditUserDetails">
                            <s:param name="user_id" value="%{user_id}"></s:param>
                        </s:url>
                        <s:a href="%{editURL}">Edit</s:a>
                    </td>
                    <td>
                        <s:url id="deleteURL" action="deleteUser">
                            <s:param name="user_id" value="%{user_id}"></s:param>
                        </s:url>
                        <s:a href="%{deleteURL}">Delete</s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </div>
</s:if>
</body>
</html>