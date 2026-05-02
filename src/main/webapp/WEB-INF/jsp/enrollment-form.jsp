<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/enrollments/save" method="post">
    Name: <input type="text" name="studentName"/><br>
    Email: <input type="text" name="email"/><br>

    Course:
    <select name="course.id">
        <c:forEach var="c" items="${courses}">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select>

    <button type="submit">Save</button>
</form>
