<%-- 
    Document   : lista-zaduzenja
    Created on : Sep 8, 2017, 3:17:14 PM
    Author     : Srdjan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista zaduzenja</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="topBar.jsp" %>

        <form:form action="trazi-zaduzenje" method="POST">
            Trazi zaduzenje: <input type="text" name="theSearchName" />

            <input type="submit" value="Search" class="add-button" />
        </form:form>

        <div class="container">
            <h1>Lista zaduzenja</h1>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Redni Broj</th>
                        <th>Oblast</th>
                        <th>Nivo</th>
                        <th>Id Zaposlenog</th>
                        <th>Promeni</th>
                        <th>Obrisi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaZaduzenja}" var="zaduzenje">
                        <tr>
                            <td>${zaduzenje.id}</td>
                            <td>${zaduzenje.oblast}</td>
                            <td>${zaduzenje.nivo}</td>
                            <td>${zaduzenje.employeeId}</td>
                            <td><a class="btn btn-default" href="promenazad?id=${zaduzenje.id}">Promeni <span class="glyphicon glyphicon-edit text-info"></span></a></td>
                            <td><a class="btn btn-default" href="brisanjezad?id=${zaduzenje.id}">Obrisi <span class="glyphicon glyphicon-trash text-danger"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
