<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Spring Boot Example</title>
<link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
</head>
<body>
<div>

<c:if test="${not empty usersView}">
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> All Users</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
        <div class="col-md-4 text-center"><strong>Id</strong></div>
        <div class="col-md-4 text-center"><strong>Name</strong></div>
        <div class="col-md-4 text-center"><strong>Email</strong></div>
    </div>
        <c:forEach var="user" items="${users}">
            <div class="row" style="border:1px solid green;padding:10px">
            <div class="col-md-4 text-center">${user.id}</div>
            <div class="col-md-4 text-center" >${user.name}</div>
            <div class="col-md-4 text-center">${user.email}</div>
            </div>
        </c:forEach>

</div>
</c:if>

<c:if test="${not empty userNamesView}">
<div class="container" style="margin:50px">
    <div class="row text-center"><strong> User Names</strong></div>
        <c:forEach var="userName" items="${userNames}">
            <div class="row" style="border:1px solid green;padding:10px">
            <div class="col-md-4 text-center" >${userName}</div>
            </div>
        </c:forEach>

</div>
</c:if>

<c:if test="${not empty userProfile}">
<div class="container">
  <h2>User</h2>
  <div class="well">${user.name}</div>
  <div class="well">${user.email}</div>
</div>
</c:if>

</div>
</body>
</html>