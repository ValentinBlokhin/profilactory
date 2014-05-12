<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 5/9/2014
  Time: 11:35 PM
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
                <legend>Add room to base</legend>
                <form:form method="post" cssClass="form-horizontal" modelAttribute="addRoom"
                           action="/manage/room/addRoom">
                    <div class="form-group padding-form">
                        <label class="col-sm-2 control-label" for="roomNumberInput">Room number</label>

                        <div class="col-sm-3">
                            <form:input path="roomNumber" id="roomNumberInput" cssClass="form-control" type="number"/>

                        </div>
                        <div class="col-sm-7">
                            <form:errors path="roomNumber" cssClass="form-error-text text-danger"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="seats">Seats</label>

                        <div class="col-sm-3">
                            <form:input path="seats" id="seats" cssClass="form-control"/>
                        </div>
                        <div class="col-sm-7">

                            <form:errors path="seats" cssClass="form-error-text text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" class="btn btn-primary">
                        </div>
                    </div>
                </form:form> <%-- room form --%>
            </fieldset>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>