<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/28/2014
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<tiles:insertDefinition name="manage/permit">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
            <div class="tab-content">
                    <%--<div class="tab-pane fade active in" id="patient-div">--%>
                <div class="alert alert-success hide" id="alertBlock">
                    <button type="button" class="close" data-dismiss="alert">x</button>
                </div>
                <a href="<c:url value="/manage/permit/add"/>" class="btn btn-success " role="button">New permit</a>

                <table id="managePatientTable" class="table table-striped table-bordered" cellpadding="0" width="100%">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>CHECK_IN</th>
                        <th>CHECK_OUT</th>
                        <th>ROOM_ID</th>
                        <th>PATIENT_ID</th>
                        <th>*</th>
                        <th>*</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="permits" items="${permitList}">
                        <tr>
                            <td><c:out value="${permits.permitId}"/></td>
                            <td><c:out value="${permits.checkIn}"/></td>
                            <td><c:out value="${permits.checkOut}"/></td>
                            <td><c:out value="${permits.roomByRoomId.roomNumber}"/></td>
                            <td><c:out value="${permits.patientByPatientId.patientId}"/></td>
                            <td><a href="/manage/permit/edit/${permits.permitId}" class="btn btn-default">edit</a></td>
                            <td><a href="/manage/permit/delete/${permits.permitId}" class="btn btn-default">delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>