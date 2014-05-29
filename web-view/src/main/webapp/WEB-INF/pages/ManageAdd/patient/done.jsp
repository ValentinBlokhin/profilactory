<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/28/2014
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertDefinition name="manage/patient">
    <tiles:putAttribute name="body">

        <div class="col-md-9 content-nav">
        <fieldset>
            <legend>Rood added</legend>
            <table class="table table-hover table-bordered table-style">
                <thead>
                <tr>
                    <th>First name</th>
                    <th>Second name</th>
                    <th>Middle name</th>
                    <th>Student id</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th><c:out value="${patientValues.firstName}"/></th>
                    <th><c:out value="${patientValues.secondName}"/></th>
                    <th><c:out value="${patientValues.middleName}"/></th>
                    <th><c:out value="${patientValues.studentId}"/></th>
                </tr>

                </tbody>

            </table>
            <div class="col-sm-10">
                <a href="<c:url value="/manage/patient"/>" class="btn btn-info" role="button">Back</a>
            </div>
        </fieldset>

    </tiles:putAttribute>
</tiles:insertDefinition>