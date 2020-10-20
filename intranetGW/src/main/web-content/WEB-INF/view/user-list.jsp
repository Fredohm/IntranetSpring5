<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 10-10-20
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Liste des utilisateurs</title>

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

        <h2>Liste des utilisateurs</h2>

        <table>

            <tr>

                <th>Username: </th>
                <th>Link: </th>

            </tr>

            <c:forEach var="tempUser" items="${users}">

                <tr>
                    <td>${tempUser.username}</td>
                    <td>
                        <a href="
                          <c:url value="/user/display">
                            <c:param name="id" value="${tempUser.id}"/>
                          </c:url>
                        ">
                            See
                        </a>
                    </td>

                </tr>

            </c:forEach>

        </table>

        <br />
        <br />

        <a href="${pageContext.request.contextPath}/user/add" role="button">Register new user</a>
        <br /><br />

        <a href="<c:url value="/"/>">Vers l'accueil</a>

    </body>

</html>
