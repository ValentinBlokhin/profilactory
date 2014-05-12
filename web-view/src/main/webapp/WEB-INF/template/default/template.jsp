<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/9/2014
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="tilesex" uri="http://tiles.apache.org/tags-tiles-extras" %>
<tilesex:useAttribute name="current"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="../../../resources/style/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="../../../resources/style/manage/style.css" />" rel="stylesheet"/>
    <script src="<c:url value="../../../resources/js/jquery-1.11.0.min.js"/>"></script>
    <script src="<c:url value="../../../resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="../../../resources/js/bootstrap-tab.js" />"></script>
    <title>Manage</title>
</head>
<body>
<div class="container">
    <tiles:insertAttribute name="header"/>

    <div class="content">
        <div class="col-md-3">
            <div class="sidebar-nav">
                <div class="navbar navbar-default" role="navigation">
                    <div class="navbar-collapse collapse sidebar-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="${current == 'manage' ? 'active' : ''}"><a href="<c:url value="/manage"/>">Menu
                                Item 1</a></li>
                            <li class="${current == 'manage/addRoom' ? 'active' : ''}"><a
                                    href="<c:url value="/manage/addRoom"/>">Menu Item 2</a></li>
                            <li><a href="#">Menu Item 3</a></li>
                            <li><a href="#">Menu Item 4</a></li>
                            <li><a href="#">Reviews</a></li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <tiles:insertAttribute name="body"/>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
