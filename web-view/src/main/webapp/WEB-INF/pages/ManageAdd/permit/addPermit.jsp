<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/28/2014
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<tiles:insertDefinition name="manage/permit">
    <tiles:putAttribute name="body">

        <div class="col-md-9 content-nav">
            <fieldset>
                <legend>New permit</legend>
                <form:form method="post" cssClass="form-horizontal" modelAttribute="addPermit"
                           action="/manage/permit/add" id="addPermitForm">
                    <div class="form-group padding-form">
                        <label class="col-sm-2 control-label">Check in</label>

                        <div class="col-sm-3">
                            <form:input path="checkIn" id="checkIn" cssClass="form-control" maxlength="15"/><span
                                id="errmsg"></span>

                        </div>
                        <div class="col-sm-5">
                            <form:errors path="checkIn" cssClass="form-error-text text-danger"
                                         data-date-format="dd-mm-yyyy"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="roomId">room number</label>

                        <div class="col-sm-3">
                            <form:select path="roomId" id="roomId" cssClass="form-control" maxlength="15">
                                <form:options items="${roomList}" itemValue="roomId" itemLabel="roomNumber"/>
                            </form:select>
                            <span
                                    id="roomIdError">

                                </span>

                        </div>
                        <div class="col-sm-7">
                            <form:errors path="roomId" cssClass="form-error-text text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="patientId">Patient last name</label>

                        <div class="col-sm-3">
                            <form:select path="patientId" id="patientId" cssClass="form-control" maxlength="15">
                                <form:options items="${patientList}" itemValue="patientId" itemLabel="secondName"/>
                            </form:select>
                            <span
                                    id="patientIdError"></span>
                        </div>
                        <div class="col-sm-7">

                            <form:errors path="patientId" cssClass="form-error-text text-danger"/>
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

