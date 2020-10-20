<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 12-10-20
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
        <title>Modification d'une utlisateur</title>

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

        <h2>${userDto.username} a bien été modifié</h2>

        <br />
        <a href="<c:url value="/user/list"/>">Vers la liste des utilisateurs</a>

    </body>

</html>

