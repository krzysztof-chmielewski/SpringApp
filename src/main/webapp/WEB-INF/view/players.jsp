<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kryst
  Date: 13/03/2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Players</title>
</head>
<body>
<ul>
    <c:forEach items="${players}" var="player">
        <li>${player}</li>
    </c:forEach>
</ul>

</body>
</html>
