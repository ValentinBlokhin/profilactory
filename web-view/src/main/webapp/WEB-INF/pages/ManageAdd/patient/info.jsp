<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 6/7/2014
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="manage/permitStats">
    <tiles:putAttribute name="body">
        <div class="col-md-9 content-nav">
            <fieldset>
                <legend>Время заезда</legend>
                <div class="form-group">
                    <label class="control-label">Начало заезда</label>
                    <span>${permitForDate.checkIn}</span>
                </div>
                <div class="form-group">
                    <label class="control-label">Конец заезда</label>
                    <span>${permitForDate.checkOut}</span>
                </div>

                <legend>Комната</legend>
                <div class="form-group">
                    <label class="control-label">Номер комнаты:</label>
                    <span>
                        <c:if test="${not empty rooms}">
                            ${rooms.roomNumber}
                        </c:if>
                    </span>
                </div>

                <legend>Диагноз</legend>
                <div class="form-group">
                    <label class="control-label">Название :</label>
                    <span>
                        <c:if test="${not empty diagnosis}">
                            ${diagnosis.name}
                        </c:if>
                    </span>
                </div>

                <legend>Лечение</legend>
                <div class="form-group">
                    <label class="control-label">Список лекарств: </label>
                    <span>
             <c:if test="${not empty drugList}">
                 <c:forEach var="drugs" items="${drugList}">
                     <ul>
                         <li>${drugs.name}</li>
                     </ul>
                 </c:forEach>
             </c:if>
                    </span>
                </div>

                <legend>Назначенные процедуры</legend>
                <div class="form-group">
                    <label class="control-label">Список процедур :</label>
                    <c:if test="${not empty procedureList}">
                        <c:forEach var="procedure" items="${procedureList}">
                            <ul>
                                <li>${procedure.name}</li>
                            </ul>
                        </c:forEach>
                    </c:if>
                </div>

                <legend>Пройденые процедуры</legend>
                <div class="form-group">
                    <label class="control-label">Список пройденых процедур - количество раз</label>
                    <c:if test="${not empty passedProcedureList}">
                        <c:forEach var="passedProcedureList" items="${passedProcedureList}">
                            <ul>
                                <li>${passedProcedureList[0]} - ${passedProcedureList[1]}</li>
                            </ul>
                        </c:forEach>
                    </c:if>
                </div>


            </fieldset>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>