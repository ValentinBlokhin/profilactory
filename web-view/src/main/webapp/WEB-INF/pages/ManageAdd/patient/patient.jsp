<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/27/2014
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<tiles:insertDefinition name="manage/patient">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
            <div class="tab-content">
                    <%--<div class="tab-pane fade active in" id="patient-div">--%>
                <div class="alert alert-success hide" id="alertBlock">
                    <button type="button" class="close" data-dismiss="alert">x</button>
                </div>
                <a href="<c:url value="/manage/patient/add"/>" class="btn btn-success " role="button">New patient</a>

                <table id="managePatientTable" class="table table-striped table-bordered" cellpadding="0" width="100%">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>FIRST_NAME</th>
                        <th>SECOND_NAME</th>
                        <th>MIDDLE_NAME</th>
                        <th>STUDENT_ID</th>
                        <th>*</th>
                        <th>*</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="patients" items="${patientsList}">
                        <tr>
                            <td><c:out value="${patients.patientId}"/></td>
                            <td><c:out value="${patients.firstName}"/></td>
                            <td><c:out value="${patients.secondName}"/></td>
                            <td><c:out value="${patients.middleName}"/></td>
                            <td><c:out value="${patients.studentId}"/></td>
                            <td><a href="/manage/patient/edit/${patients.patientId}" class="btn btn-default">edit</a>
                            </td>
                            <td><a href="/manage/patient/delete/${patients.patientId}"
                                   class="btn btn-default">delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
