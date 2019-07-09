<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello !</title>
</head>
<h2 class="hello-title">Hello !  ${message} </h2>
<body>
    <div>

    <form action = "/findstudent" method="post">
        <br>student last name:</br>
        <input type = "text" name = "studentFirstName"  />
        <br>student first name:</br>
        <input type = "text" name = "studentLastName" />
        <input type = "submit" value = "Submit" />
    </form>
    </div>
    <ul>
        <c:forEach var="listValue" items="${lists}">
            <li>${listValue}</li>
        </c:forEach>
    </ul>
</body>
</html>
