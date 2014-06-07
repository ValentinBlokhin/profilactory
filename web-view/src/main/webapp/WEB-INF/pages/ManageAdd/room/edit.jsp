<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/21/2014
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="manage/addRoom">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
            <fieldset>
                <legend>Edit room</legend>
                <c:url var="saveUrl" value="/manage/room/edit/${editRooms.roomId}"/>
                <form:form method="post" cssClass="form-horizontal" modelAttribute="editRooms"
                           action="${saveUrl}" id="editRoomForm">

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="idRoom">Room id</label>

                        <div class="col-sm-3">
                            <form:input path="roomId" id="idRoom" cssClass="form-control" disabled="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="roomNumber">Room number</label>

                        <div class="col-sm-3">
                            <form:input path="roomNumber" id="roomNumber" cssClass="form-control" onblur="checkUniq()"/><span
                                id="errmsg"></span>

                        </div>
                        <div class="col-sm-5">
                            <form:errors path="roomNumber" cssClass="form-error-text text-danger"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="seats">Seats</label>

                        <div class="col-sm-3">
                            <form:input path="seats" id="seats" cssClass="form-control room-input"/><span
                                id="seatsError"></span>
                        </div>
                        <div class="col-sm-7">

                            <form:errors path="seats" cssClass="form-error-text text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" class="btn btn-primary" id="submitButton" name="submitBtn"
                                   value="update">
                        </div>
                    </div>
                </form:form> <%-- room form --%>
            </fieldset>
        </div>
        <script src="<c:url value="../../../../resources/js/myJs.js"/> "></script>
    </tiles:putAttribute>
</tiles:insertDefinition>