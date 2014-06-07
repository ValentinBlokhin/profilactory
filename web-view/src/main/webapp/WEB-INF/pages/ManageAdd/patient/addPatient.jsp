<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/28/2014
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="manage/patient">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
            <fieldset>
                <legend>New patient</legend>
                <form:form method="post" cssClass="form-horizontal" modelAttribute="addPatient"
                           action="/manage/patient/add" id="addPatientForm">
                    <div class="form-group padding-form">
                        <label class="col-sm-2 control-label" for="firstName">First name</label>

                        <div class="col-sm-3">
                            <form:input path="firstName" id="firstName" cssClass="form-control" maxlength="15"/><span
                                id="errmsg"></span>

                        </div>
                        <div class="col-sm-5">
                            <form:errors path="firstName" cssClass="form-error-text text-danger"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="secondName">Second name</label>

                        <div class="col-sm-3">
                            <form:input path="secondName" id="secondName" cssClass="form-control" maxlength="15"/><span
                                id="secondNameError"></span>
                        </div>
                        <div class="col-sm-7">

                            <form:errors path="secondName" cssClass="form-error-text text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="middleName">Middle Name</label>

                        <div class="col-sm-3">
                            <form:input path="middleName" id="middleName" cssClass="form-control" maxlength="15"/><span
                                id="middleNameError"></span>
                        </div>
                        <div class="col-sm-7">

                            <form:errors path="middleName" cssClass="form-error-text text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="studentId">Student id</label>

                        <div class="col-sm-3">
                            <form:input path="studentId" id="studentId" cssClass="form-control" maxlength="9"/><span
                                id="studentIdError"></span>
                        </div>
                        <div class="col-sm-7">

                            <form:errors path="studentId" cssClass="form-error-text text-danger"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" class="btn btn-primary" id="submitButton" name="submitBtn">
                        </div>
                    </div>
                </form:form> <%-- room form --%>
            </fieldset>
        </div>
        <script src="<c:url value="../../../../resources/js/myJs.js"/> "></script>
    </tiles:putAttribute>
</tiles:insertDefinition>
