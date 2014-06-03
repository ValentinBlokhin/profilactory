<%--
  Created by IntelliJ IDEA.
  User: ValentinBlokhin
  Date: 6/1/2014
  Time: 7:58 PM
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
                <legend>Найти путевки по датам</legend>
                <div class="form-group">
                    <label class="control-label col-sm-2">Начальная дата</label>

                    <div class="col-sm-3">
                        <input type="date" class="form-control" id="fromInput">
                    </div>
                    <label class="control-label col-sm-2">Конечная дата</label>

                    <div class="col-sm-3">
                        <input type="date" class="form-control" id="toInput"/>
                    </div>
                </div>
                <div class="col-sm-6">
                    <button class="btn  btn-primary">Показать</button>
                </div>
            </fieldset>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>