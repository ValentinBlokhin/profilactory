<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/31/2014
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@page session="false" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<%--<h2>Custom Form based Login Page</h2>--%>
<%--<c:if test="${'fail' eq param.auth}">--%>
<%--<div style="color:red">--%>
<%--Login Failed!!!<br />--%>
<%--Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}--%>
<%--</div>--%>
<%--</c:if>--%>
<%--<form action="<c:url value='/j_spring_security_check'/>" method="post">--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td>Username:</td>--%>
<%--<td><input type='text' name='username' /></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Password:</td>--%>
<%--<td><input type='password' name='password'></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan='2'><input name="submit" type="submit" value="Submit"></td>--%>
<%--</tr>--%>
<%--</table>--%>
<form action="<c:url value='/j_spring_security_check'/>" method="post">
    <div class="container">
        <div class="row vertical-offset-100">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please sign in</h3>
                        <c:if test="${not empty error}">
                            <div style="color:red">
                                    ${error}
                            </div>
                        </c:if>
                    </div>
                    <div class="panel-body">
                        <form accept-charset="UTF-8" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password"
                                           value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="_spring_security_remember_me" type="checkbox" value="Remember Me">
                                        Remember Me
                                    </label>
                                </div>
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</body>
<link href="<c:url value="../../resources/style/bootstrap.min.css" />" rel="stylesheet"/>
<link href="<c:url value="../../resources/style/login.css" />" rel="stylesheet"/>
<script src="<c:url value="../../resources/js/bootstrap.min.js" />"></script>
</html>