<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 6/9/2014
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertDefinition name="manage/patient">
    <tiles:putAttribute name="body">

        <div class="col-md-9 content-nav">
        <fieldset>
            <legend>Permit added</legend>
            <table class="table table-hover table-bordered table-style">
                <thead>
                <tr>
                    <th>Permit id</th>
                    <th>Check in</th>
                    <th>Check out</th>
                    <th>Room id</th>
                    <th>Patient id</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th><c:out value="${permitValues.permitId}"/></th>
                    <th><c:out value="${permitValues.checkIn}"/></th>
                    <th><c:out value="${permitValues.checkOut}"/></th>
                    <th><c:out value="${permitValues.roomId}"/></th>
                    <th><c:out value="${permitValues.patientId}"/></th>
                </tr>

                </tbody>

            </table>
            <div class="col-sm-10">
                <a href="<c:url value="/manage"/>" class="btn btn-info" role="button">Back</a>
            </div>
        </fieldset>

    </tiles:putAttribute>
</tiles:insertDefinition>
