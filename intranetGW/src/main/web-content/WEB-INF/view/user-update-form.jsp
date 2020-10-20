<%@ taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 12-10-20
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Modification d'un utilisateur</title>

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

        <form:form action="processUpdate" modelAttribute="userDto" method="post">

            <form:hidden path="id" />

            <table>

                <tbody>

                    <tr>
                        <td><form:input path="username" placeholder="username(*)"/></td>
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
                        <td>
                            <form:select path="formRole" items="${roles}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Update"></td>
                    </tr>

                </tbody>

            </table>

        </form:form>

        <br />

        <a href="<c:url value="/user/list"/>">Vers la liste des utilisateurs</a>

    </body>

</html>