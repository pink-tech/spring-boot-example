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
<div class="container" style="margin:50px">
<div class="col-md-4 text-center">Session Info [sessionAttributes - ${emailId} ${sessionId}, modelAttributes - ${sessionScope.emailId} ${sessionScope.sessionId}]</div>
</br>
<c:if test="${empty sessionScope.sessionId}">
${sessionScope.sessionId}
<form action="/validateAndLogin" method="POST" modelAttribute="loggingUser">
  <div class="form-group">
    <label for="emailId">Email address</label>
    <!-- name attribute is needed for passing the value to modelAttribute -->
    <input type="email" class="form-control" id="emailId" name="email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</c:if>

<c:if test="${not empty sessionScope.sessionId}">
<div class="col-md-4 text-center">${sessionScope.emailId} has loggedIn.</div>
<form action="/destroySessionAndLogout" method="POST" modelAttribute="loggedInUser">
  <input type="hidden" id="emailId" name="email" value="${emailId}">
  <input type="hidden" id="sessionId" name="sessionId" value="${sessionId}">
  <button type="submit" class="btn btn-primary">Logout</button>
</form>
</c:if>

</div>
</div>
</body>
</html>