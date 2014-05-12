<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 4/23/2014
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<tiles:insertDefinition name="manage">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
        <div class="tab-content">
            <div class="tab-pane fade active in" id="room-div">
                <a href="<c:url value="/manage/room/addRoom"/>" class="btn btn-success" role="button">Add room</a>

                <table class="table table-hover table-bordered table-style">
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
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>
