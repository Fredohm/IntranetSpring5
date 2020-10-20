<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 05-10-20
  Time: 06:37
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglibs.jsp"%>

<!doctype html>
<html lang="fr">
<head>

    <meta charset="UTF-8">
    <title>IntranetGW</title>

</head>

<body>

    <c:import url="header.jsp"/>

    <div>
        User: <security:authentication property="principal.username" />
        <br />
        Role(s): <security:authentication property="principal.authorities" />
        <br />
        <hr>
        <br />
    </div>

    <hr>

    <a href="<c:url value="/meeting-room/list"/>">Vers la liste des salles</a>
    <br /><br />

    <security:authorize access="hasRole('ADMIN')">

        <a href="<c:url value="/user/list"/>">Vers la liste des utilisateurs</a>
        <br /><br />

    </security:authorize>


    <form:form action="${pageContext.request.contextPath}/logout" method="post">

        <input type="submit" value="Logout"/>

    </form:form>

</body>
</html>

