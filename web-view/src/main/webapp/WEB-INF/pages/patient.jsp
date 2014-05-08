<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 4/23/2014
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<!doctype html>--%>

<html>
<head>
    <link href="<c:url value="../../resources/style/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="../../resources/style/addPages/style.css" />" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery-1.11.0.min.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="../../resources/js/bootstrap-tab.js" />"></script>
    <meta charset="utf-8"/>
    <title>add Patient</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 header"></div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked padding-sidebar">
                <li class="active">
                    <a href="#room-div" data-toggle="tab">Room</a>
                </li>
                <li>
                    <a href="#permit" data-toggle="tab">Permit</a>
                </li>
                <li>
                    <a href="#" data-toggle="tab">Third</a>
                </li>
            </ul>
        </div>
        <div class="col-md-9 content-nav">


            <div class="tab-content">
                <div class="tab-pane fade active in" id="room-div">

                    .
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Room number</th>
                            <th>Seats</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="rooms" items="${roomList}">
                            <tr>
                                <td><c:out value="${rooms.roomId}"/></td>
                                <td><c:out value="${rooms.roomNumber}"/></td>
                                <td><c:out value="${rooms.seats}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                    <%--<form:form method="post" cssClass="form-horizontal">--%>
                    <%--<div class="form-group padding-form">--%>
                    <%--<label class="col-sm-2 control-label" for="roomNumberInput">Room number</label>--%>

                    <%--<div class="col-sm-3">--%>
                    <%--<form:input path="roomNumber" id="roomNumberInput" cssClass="form-control"/>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                    <%--<label class="control-label col-sm-2" for="seats">Seats</label>--%>

                    <%--<div class="col-sm-3">--%>
                    <%--<form:input path="seats" id="seats" cssClass="form-control"/>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                    <%--<div class="col-sm-offset-2 col-sm-10">--%>
                    <%--<input type="submit" class="btn btn-primary">--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</form:form> &lt;%&ndash; room form &ndash;%&gt;--%>
            </div>

                <%--<div class="tab-pane" id="permit">--%>
                <%--<form:form method="post" cssClass="form-horizontal">--%>
                <%--<div class="form-group padding-form">--%>
                <%--<div class="col-sm-3">--%>
                <%--<label class="col-sm-2 control-label" for="CheckIdInput">Check in date</label>--%>

                <%--<div class="col-sm-3">--%>
                <%--<form:input path="checkIn" id="CheckIdInput" cssClass="form-control"/>--%>
                <%--</div>--%>

                <%--</div>--%>
                <%--</div>--%>
                <%--</form:form>--%>
                <%--</div>--%>
            </div>


        </div>
    </div>

    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
</html>
