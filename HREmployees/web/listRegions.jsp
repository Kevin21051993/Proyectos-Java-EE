<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 23/06/2017
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Regions</title>
</head>
<body>
    <jsp:useBean id="service" class="pe.edu.utp.hremployees.services.HRService"/>
    <c:forEach var="region" items="${service.regions}">
        <p><c:out value="${region.name}"/>
           <a href="regions?action=edit&id=<c:out value="${region.id}"/>">
               Edit
           </a>
        </p>
    </c:forEach>
    <a href="regions?action=add">Add Region</a>
</body>
</html>
