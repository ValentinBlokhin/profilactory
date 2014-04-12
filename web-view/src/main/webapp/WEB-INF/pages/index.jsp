<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 4/19/2014
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="../../resources/style/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="../../resources/style/style.css" />" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-1.11.0.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap.min.js" />"></script>
    <meta charset="utf-8"/>
    <title>hello</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 header">

            <div class="col-md-6">
                <a href="#"><img src="../../resources/images/logo.png" alt="logo" class="img-rounded logo-img"></a>
            </div>
            <div class="col-md-6">
                <ul class="nav nav-pills nav-pos">
                    <li><a href="#">ABOUT US</a></li>
                    <li><a href="#">TREATMENT</a></li>
                    <li><a href="#">NEWS</a></li>
                    <li><a href="#">GALLERY</a></li>
                    <li><a href="#">CONTACTS</a></li>
                </ul>
            </div>
        </div>
    </div>
    <%-- header--%>

    <div class="container middle-container">
        <div class="row">
            <div class="col-md-6">
                <img src="../../resources/images/middle-container_left.png" alt="left logo"
                     class="img-rounded middle-logo-left">
            </div>
            <div class="col-md-6">
                <img src="../../resources/images/middle-container_right.png" alt="right logo"
                     class="img-rounded middle-logo-right">
            </div>
        </div>
        <%-- middle--%>

        <div class="row sign-block">
            <div class="col-md-7 sign-block-left_side">
                professional

                <span>treatment program</span>
            </div>
            <div class="col-md-4 sign-block-right_side-button">
                <a href="#" class="btn">learn more</a>
            </div>
        </div>
        <%-- sing block--%>
    </div>
    <%-- middle container--%>
    <div class="row">
        <div class="col-md-12 footer">
            <div class="col-md-6 footer-left">(c)2014</div>
            <div class="col-md-5 footer-right"><span class="glyphicon glyphicon-home"> г.Харьков, ул. Бакулина, 16, индекс 61166</span>
            </div>
        </div>
    </div>
    <%-- footer --%>

</div>
</body>
</html>
