<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/10/2014
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertDefinition name="manage/addRoom">
    <tiles:putAttribute name="body">

        <div class="col-md-9 content-nav">
        <fieldset>
            <legend>Rood added</legend>
            <table class="table table-hover table-bordered table-style">
                <thead>
                <tr>
                    <th>Room number</th>
                    <th>Seats</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th><c:out value="${roomValues.roomNumber}"/></th>
                    <th><c:out value="${roomValues.seats}"/></th>
                </tr>

                </tbody>

            </table>
            <div class="col-sm-10">
                <a href="<c:url value="/manage"/>" class="btn btn-info" role="button">Back</a>
            </div>
        </fieldset>

    </tiles:putAttribute>
</tiles:insertDefinition>