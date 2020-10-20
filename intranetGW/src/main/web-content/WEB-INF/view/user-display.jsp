<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 10-10-20
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Affichage d'une utilisateur</title>

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

        <h2>${user.username}</h2>

        First name: ${user.firstName}<br />
        Last name: ${user.lastName}<br />
        Email: ${user.email}<br />
        Roles: ${user.roles}<br />



        <br />

        <!-- Update link -->
        <c:url var="updateLink" value="/user/update">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <!-- Delete link -->
        <c:url var="deleteLink" value="/user/delete">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <!-- display the update link -->
        <td>
            <a href="${updateLink}">Update</a>
        </td>
        <!-- display the delete link -->
        <td>
            <a href="${deleteLink}" onclick="if (!(confirm('Delete?'))) return false">Delete</a>
        </td>

        <br /><br />

        <a href="<c:url value="/user/list"/>">Vers la liste des utilisateurs</a>

    </body>

</html>
