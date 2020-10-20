<%--
  Created by IntelliJ IDEA.
  User: FredOhm0603
  Date: 04-10-20
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglibs.jsp"%>

<!doctype html>
<html>

    <head>

        <meta charset="UTF-8">
        <title>Intranet - Access denied</title>

    </head>

    <body>

        <%@include file="header.jsp"%>

        <h2>Access denied - You are not authorized to access this resource.</h2>

        <br />

        <a href="<c:url value=".."/>">Back</a>

    </body>
</html>
