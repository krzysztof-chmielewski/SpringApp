<%--
  Created by IntelliJ IDEA.
  User: kryst
  Date: 13/03/2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="players" type="java.util.List"--%>
<html>
<head>
    <title>Form</title>

    <style>
        .heading {
            margin-top: 60px;
            margin-bottom: 50px;
            text-align: center;
            color: #599532;
            font-family: sans-serif;
        }

        .form {
            margin: 0 auto;
            margin-top: 10px;
            width: 80%;
        }

        .list {
            counter-reset: list;
            list-style: none;
            -webkit-padding-start: 0;
        }

        .list_el {
            text-align: center;
            counter-increment: list;
            margin-bottom: 10px;
            cursor: pointer;
        }

        .list_el::before {
            content: counter(list, decimal-leading-zero);
            background: #2b4353;
            font-family: Arial, sans-serif;
            color: #fff;
            font-size: 13px;
            text-align: center;
            border-radius: 50%;
            width: 2.2em;
            height: 2.2em;
            line-height: 2.3em;
            display: inline-block;
            margin-right: 1em;
        }

    </style>
</head>
<body>
<h1 class="heading">Spring App</h1>

<form:form method="post" modelAttribute="player" action="/players/form">

    <label>Name:<form:input path="firstName" type="text"/></label>
    <label>Surname:<form:input path="lastName" type="text"/></label>
    <button type="submit" value="ADD">Add</button>

</form:form>

<ol class="list">
    <c:forEach items="${players}" var="player">
        <li class="list_el">${player.firstName} ${player.lastName}</li>
    </c:forEach>
</ol>
</body>
</html>
