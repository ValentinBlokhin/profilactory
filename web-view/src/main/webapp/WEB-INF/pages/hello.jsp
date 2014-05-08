<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 4/21/2014
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<c:forEach items="${list}" var="myList">
    <c:out value="${myList.name}"/>
</c:forEach>
<body>

</body>
</html>
