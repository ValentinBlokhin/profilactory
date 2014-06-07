<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 6/4/2014
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<tiles:insertDefinition name="manage/permitByDate">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
        <div class="tab-content">
            <table id="statTable" class="table table-striped table-bordered" cellpadding="0" width="100%">
                <thead>
                <tr>
                    <th>FIRST_NAME</th>
                    <th>SECOND_NAME</th>
                    <th>MIDDLE_NAME</th>
                    <th>STUDENT_ID</th>
                    <th>CHECK_IN</th>
                    <th>CHECK_OUT</th>
                    <th>ROOM NUMBER</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="result" items="${resultList}">
                    <tr>
                        <td><c:out value="${result[1].patientByPatientId.firstName}"/></td>
                        <td><c:out value="${result[1].patientByPatientId.secondName}"/></td>
                        <td><c:out value="${result[1].patientByPatientId.middleName}"/></td>
                        <td><c:out value="${result[1].patientByPatientId.studentId}"/></td>
                        <td><c:out value="${result[1].checkIn}"/></td>
                        <td><c:out value="${result[1].checkOut}"/></td>
                        <td><c:out value="${result[1].roomByRoomId.roomNumber}"/></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>