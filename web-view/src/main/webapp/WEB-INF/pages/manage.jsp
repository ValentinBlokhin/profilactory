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
<%@page session="true" %>
<!doctype html>
<tiles:insertDefinition name="manage">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
            <div class="tab-content">
                    <%--<div class="tab-pane fade active in" id="room-div">--%>
                <div class="alert alert-success hide" id="alertBlock">
                    <button type="button" class="close" data-dismiss="alert">x</button>
                </div>
                <a href="<c:url value="/manage/room/addRoom"/>" class="btn btn-success " role="button">Add room</a>

                <table id="manageRoomTable" class="table table-striped table-bordered" cellpadding="0" width="100%">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Room number</th>
                        <th>Seats</th>
                        <th>Busy seats</th>
                        <th>*</th>
                        <th>*</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="rooms" items="${roomList}">
                        <tr>
                            <td><c:out value="${rooms.roomId}"/></td>
                            <td><c:out value="${rooms.roomNumber}"/></td>
                            <td><c:out value="${rooms.seats}"/></td>
                            <td><c:out value="${rooms.busySeats}"/></td>
                            <td><a href="/manage/room/edit/${rooms.roomId}" class="btn btn-default">edit</a></td>
                            <td>
                                <button class="btn btn-default" onclick="deleteRoom(${rooms.roomId})">delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>
