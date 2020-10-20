<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 10-10-20
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Ajout d'un utilisateur</title>

    </head>

        <body>

            <h1>Intranet GW</h1>
            <br />

            <hr>

            <div>
                User: <security:authentication property="principal.username" />
                <br />
                Role(s): <security:authentication property="principal.authorities" />
                <br />
                <hr>
                <br />
            </div>

            <h2>${userDto.username} a bien été ajouté</h2>

            <br />
            <a href="<c:url value="/user/list"/>">Vers la liste des utilisateurs</a>

        </body>

</html>
