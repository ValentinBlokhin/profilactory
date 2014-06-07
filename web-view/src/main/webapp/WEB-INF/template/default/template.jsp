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
    <link href="<c:url value="../../../resources/style/datepicker.css" />" rel="stylesheet"/>
    <link href="<c:url value="../../../resources/style/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="../../../resources/style/jquery.dataTables.css"/>  " rel="stylesheet"/>
    <link href="<c:url value="../../../resources/style/dataTables.bootstrap.css"/>  " rel="stylesheet"/>
    <link href="<c:url value="../../../resources/style/manage/style.css" />" rel="stylesheet"/>
    <script src="<c:url value="../../../resources/js/jquery-1.10.2.js"/>"></script>
    <script src="<c:url value="../../../resources/js/bootstrap-datepicker.js"/> "></script>
    <script src="<c:url value="../../../resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="../../../resources/js/bootstrap-tab.js" />"></script>
    <script src="<c:url value="../../../resources/js/jquery.dataTables.js"/> "></script>
    <script src="<c:url value="../../../resources/js/dataTables.bootstrap.js"/> "></script>
    <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
    <title>Manage</title>
</head>
<body>
<div class="container">
    <tiles:insertAttribute name="header"/>

    <div class="row">
        <div class="col-md-3">
            <div class="sidebar-nav sidebar-nav-margin-top div-shadow">
                <div class="navbar navbar-default" role="navigation">
                    <div class="navbar-collapse collapse sidebar-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="${current == 'manage' ? 'active' : ''}"><a
                                    href="<c:url value="/manage"/>">Rooms</a></li>
                            <li class="${current == 'manage/patient' ? 'active' : ''}"><a
                                    href="<c:url value="/manage/patient"/>">Patients</a></li>
                            <li class="${current == 'manage/permit' ? 'active' : ''}"><a
                                    href="<c:url value="/manage/permit"/>">Permits</a></li>
                            <li class="${current == 'manage/permitstatistics' ? 'active' : ''}"><a
                                    href="<c:url value="/manage/permitstatistics"/> ">Statistics</a></li>
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
