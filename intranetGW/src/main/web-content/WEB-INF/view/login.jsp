<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 04-10-20
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglibs.jsp"%>

<!doctype html>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <c:import url="header.jsp"/>

    <h3>Login to the intranet</h3>

    <form:form action="${pageContext.request.contextPath}/authenticate-user" method="post">
        
        <c:if test="${param.error != null}">
            <i>Invalid username/password.</i>
        </c:if>

        <c:if test="${param.logout != null}">
            <i>You've been logged out.</i>
        </c:if>

        <p>Username <input type="text" name="username"/></p>
        <p>Password <input type="password" name="password"/></p>

        <input type="submit" value="Login"/>

    </form:form>

</body>
</html>
