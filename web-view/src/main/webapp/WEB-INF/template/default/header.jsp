<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/9/2014
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="row">
    <div class="col-md-12 header div-shadow">
        <div class="col-sm-3 col-sm-offset-9">
            <span id="nameText"> Hello, ${pageContext.request.userPrincipal.name}</span>
            <security:authorize access="isAuthenticated()">
                <a class="btn btn-default btn-mini" href="<c:url value="j_spring_security_logout"/>">Logout</a>
            </security:authorize>
        </div>
    </div>
</div>
