<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 28-09-20
  Time: 05:39
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Affichage d'une salle</title>
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

        <h2>${meetingRoom.meetingRoomName}</h2>

        Nombre de places: ${meetingRoom.meetingRoomPlacesNb}<br />
        Location: ${meetingRoom.location}<br />
        Description: ${meetingRoom.description}<br />
        Disponible: ${meetingRoom.available}<br />

        <br />

        <!-- Update link -->
        <c:url var="updateLink" value="/meeting-room/update">
            <c:param name="meetingRoomId" value="${meetingRoom.id}"/>
        </c:url>

        <!-- Delete link -->
        <c:url var="deleteLink" value="/meeting-room/delete">
            <c:param name="meetingRoomId" value="${meetingRoom.id}"/>
        </c:url>

        <!-- display the update link -->
        <security:authorize access="hasRole('ADMIN')">

            <td>
                <a href="${updateLink}">Update</a>
            </td>
            <!-- display the delete link -->
            <td>
                <a href="${deleteLink}" onclick="if (!(confirm('Delete?'))) return false">Delete</a>
            </td>

        </security:authorize>

        <br />

        <a href="<c:url value="/meeting-room/list"/>">Vers la liste des salles</a>

    </body>

</html>
