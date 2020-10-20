<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 26-09-20
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Liste des salles</title>

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

        <h2>Liste des salles</h2>

        <table>

            <tr>

                <th>Salle: </th>
                <th>Nb de places: </th>
                <th>Lien</th>

            </tr>

            <c:forEach var="tempRoom" items="${rooms}">

                <tr>
                    <td>${tempRoom.meetingRoomName}</td>
                    <td>${tempRoom.meetingRoomPlacesNb}</td>
                    <td>
                        <a href="
                                <c:url value="/meeting-room/display">
                                    <c:param name="id" value="${tempRoom.id}"/>
                                </c:url>
                            ">
                            voir
                        </a>
                    </td>

                </tr>

            </c:forEach>

        </table>

        <br />
        <p>
            <security:authorize access="hasRole('ADMIN')">

                <a href="<c:url value="/meeting-room/add"/>">Add a meeting room</a>

            </security:authorize>
        </p>


        <br />
        <br />


        <a href="<c:url value="/"/>">Vers l'accueil</a>

    </body>

</html>
