<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<p>Your email is confirmed successfully. Please, re-check the details.</p>


    Language : ${email.language} </br>
    Page Size : ${email.pageSize} </br>
    Spams :
    <ul>
        <c:forEach var="spams" items="${email.spam}">
            <li>${spams}</li>
        </c:forEach>
    </ul>
    Sign: ${email.signature}</td>

</body>
</html>