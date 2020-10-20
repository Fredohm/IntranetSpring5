<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 26-09-20
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Ajout d'une salle</title>

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

        <form:form action="save" modelAttribute="meetingRoom" method="post">

            <form:hidden path="id"/>

            <table>

                <tbody>
                    <tr>
                        <td>Room name: </td>
                        <td><form:input path="meetingRoomName" /></td>
                    </tr>
                    <tr>
                        <td>Number of places: </td>
                        <td><form:input path="meetingRoomPlacesNb" /></td>
                    </tr>
                    <tr>
                        <td>Location: </td>
                        <td><form:input path="location" /></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><form:input path="description" /></td>
                    </tr>
                    <tr>
                        <td>Available</td>
                        <td><form:checkbox path="available" /></td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Save"></td>
                    </tr>

                </tbody>

            </table>

        </form:form>

        <br />

        <a href="<c:url value="/meeting-room/list"/>">Vers la liste des salles</a>

    </body>

</html>
