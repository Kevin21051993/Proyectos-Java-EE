<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GrupoUTP
  Date: 01/07/2017
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="service"
             class="pe.edu.utp.hremployees.services.HRService"/>
<form action="regions" method="post">
    <input type="text" name="id" value="${region.id}"
    <c:out value="${action == 'edit' ? 'readonly=\"readonly\"' : '' }"/>
    />
    <input type="text" name="name" value="${region.name}"/>
    <input type="hidden" value="update" name="action"/>
    <input type="submit"/>
</form>

