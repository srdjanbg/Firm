<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista zaposlenih</title>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="topBar.jsp" %>

        <form:form action="trazi-zaposlenog" method="POST">
            Trazi zaposlenog: <input type="text" name="theSearchName" />

            <input type="submit" value="Search" class="add-button" />
        </form:form>

        <div class="container">
            <h1>Lista zaposlenih</h1>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Redni Broj</th>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Pozicija u firmi</th>
                        <th>Plata</th>
                        <th>Staz</th>
                        <th>Oblast</th>
                        <th>Nivo</th>
                        <th>Promeni</th>
                        <th>Obrisi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaZaposlenih}" var="zaposleni">
                        <tr>
                            <c:choose>
                                <c:when test="${zaposleni.ime==''}">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>${zaposleni.oblast}</td>
                                    <td>${zaposleni.nivo}</td>
                                </c:when>    

                                <c:otherwise>
                                    <td>${zaposleni.id}</td>
                                    <td>${zaposleni.ime}</td>
                                    <td>${zaposleni.prezime}</td>
                                    <td>${zaposleni.pozicija}</td>
                                    <td>${zaposleni.plata}</td>
                                    <td>${zaposleni.staz}</td>
                                    <td>${zaposleni.oblast}</td>
                                    <td>${zaposleni.nivo}</td>
                                </c:otherwise>
                            </c:choose>


                            <td><a class="btn btn-default" href="promena?id=${zaposleni.id}">Promeni <span class="glyphicon glyphicon-edit text-info"></span></a></td>
                            <td><a class="btn btn-default" href="brisanje?id=${zaposleni.id}">Obrisi <span class="glyphicon glyphicon-trash text-danger"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
