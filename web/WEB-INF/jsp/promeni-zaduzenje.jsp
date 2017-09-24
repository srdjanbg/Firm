<%-- 
    Document   : promeni-zaduzenje
    Created on : Sep 8, 2017, 3:17:34 PM
    Author     : Srdjan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmeni zaduzenje</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="topBar.jsp" %>
        <div class="container">
            <h1>Izmeni zaduzenje</h1>

            <sf:form class="form-horizontal" method="POST" action="menjaj-zaduzenje" modelAttribute="promenjenoZaduzenje">
                <c:if test="${hasErrors}">
                    <div class="alert alert-danger">
                        <sf:errors path="*"></sf:errors>
                    </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="ime">Oblast:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="oblast" 
                                  path="oblast" placeholder="Upisite oblast u kojoj radi zaposleni"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="nivo">
                        Nivo:
                    </label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="nivo" 
                                  path="nivo" placeholder="Upisite nivo znanja zaposlenog"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="employeeId">Id zaposlenog:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="employeeId" path="employeeId"  placeholder="Upisite id zaposlenog"/>
                    </div>
                </div>
                
                    
                <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                        <sf:hidden path="id"></sf:hidden>
                        <sf:button type="submit" class="btn btn-default">Izmeni zaduzenje</sf:button>
                        <a class="btn btn-primary"href="lista-zaposlenih">Vrati se na listu</a>
                        </div>
                    </div>
            </sf:form>
        </div>
        
        
    </body>
</html>
