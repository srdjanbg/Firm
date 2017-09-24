<%-- 
    Document   : topBar
    Created on : Aug 30, 2017, 12:23:37 AM
    Author     : Srdjan
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


  <link href="resources/css/styles.css" rel="stylesheet">

<nav class="navbar navbar-inverse">
    <div class="container-fluid">


        <div class="navbar-header">
            <a class="navbar-brand" href="home">Firma</a>
        </div>

        
        


        <ul class="nav navbar-nav">
            <li id="home"><a href="home">Home</a></li>
            <li id="dodaj-zaposlenog"><a href="dodaj-zaposlenog">Dodaj zaposlenog</a></li>
            <li id="lista-zaposlenih"><a href="lista-zaposlenih">Lista zaposlenih</a></li>
            <li id="dodaj-zaduzenje"><a href="dodaj-zaduzenje">Dodaj zaduzenje</a></li>
            <li id="lista-zaduzenja"><a href="lista-zaduzenja">Lista zaduzenja</a></li>
            <li id="about"><a href="about">About</a></li>
        </ul>
    </div>
    
    <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2><font color="#006699">Welcome, ${pageContext.request.userPrincipal.name}</h2> |
            <sf:form action="${pageContext.request.contextPath}/logout" method="POST">
                <input type="submit" value="Log out" />
            </sf:form>
        </c:if>

    
</nav>
