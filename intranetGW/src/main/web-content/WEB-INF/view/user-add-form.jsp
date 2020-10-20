<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 10-10-20
  Time: 10:12
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

        <c:import url="header.jsp"/>

        <div>
            User: <security:authentication property="principal.username" />
            <br />
            Role(s): <security:authentication property="principal.authorities" />
            <br />
            <hr>
            <br />
        </div>

        <form:form action="save" modelAttribute="userDto" method="post">

            <c:if test="${registrationError != null}">
                ${registrationError}
            </c:if>

            <table>

                <tbody>

                <tr>
                    <td><form:input path="username" placeholder="username(*)" /></td>
                    <td><form:errors path="username"/></td>
                </tr>
                <tr>
                    <td><form:password path="password" placeholder="password(*)"/></td>
                    <td><form:errors path="password"/></td>
                </tr>
                <tr>
                    <td><form:password path="matchingPassword" placeholder="matching password(*)"/></td>
                    <td><form:errors path="matchingPassword"/></td>
                </tr>
                <tr>
                    <td><form:input path="firstName" placeholder="first name(*)"/></td>
                    <td><form:errors path="firstName"/></td>
                </tr>
                <tr>
                    <td><form:input path="lastName" placeholder="last name(*)"/></td>
                    <td><form:errors path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:input path="email" placeholder="email(*)"/></td>
                    <td><form:errors path="email"/></td>
                </tr>
                <tr>
                    <td><form:select path="formRole" items="${roles}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add"></td>
                </tr>


                </tbody>

            </table>

        </form:form>

        <br />

        <a href="<c:url value="/user/list"/>">Vers la liste des utilisateurs</a>

    </body>

</html>