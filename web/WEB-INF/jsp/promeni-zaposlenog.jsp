<%-- 
    Document   : promeni-zaposlenog
    Created on : Aug 30, 2017, 12:23:08 AM
    Author     : Srdjan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izmeni zaposlenog</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="topBar.jsp" %>
        <div class="container">
            <h1>Izmeni zaposlenog</h1>

            <sf:form class="form-horizontal" method="POST" action="menjaj-zaposlenog" modelAttribute="promenjenZaposleni">
                <c:if test="${hasErrors}">
                    <div class="alert alert-danger">
                        <sf:errors path="*"></sf:errors>
                    </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="ime">Ime:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="ime" 
                                  path="ime" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="prezime">
                        Prezime:
                    </label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="prezime" 
                                  path="prezime" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pozicija">Pozicija:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="pozicija" path="pozicija" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="plata">Plata:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="plata" path="plata"  />
                    </div>
                </div>
                    
                    <div class="form-group">
                    <label class="control-label col-sm-2" for="staz">Staz:</label>
                    <div class="col-sm-10">
                        <sf:input type="text" class="form-control" id="staz" path="staz"  />
                    </div>
                </div>
                    
                <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                        <sf:hidden path="id"></sf:hidden>
                        <sf:button type="submit" class="btn btn-default">Izmeni zaposlenog</sf:button>
                        <a class="btn btn-primary"href="lista-zaposlenih">Vrati se na listu</a>
                        </div>
                    </div>
            </sf:form>
        </div>
        
        
    </body>
</html>
