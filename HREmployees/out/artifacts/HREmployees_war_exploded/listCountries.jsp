<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 24/06/2017
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Countries</title>
</head>
<body>
    <jsp:useBean id="service" class="pe.edu.utp.hremployees.services.HRService"/>
    <c:forEach var="country" items="${service.countries}">
        <p><c:out value="${country.name}"/> <c:out value="${country.region.name}"/></p>
    </c:forEach>
</body>
</html>
