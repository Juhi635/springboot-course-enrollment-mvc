<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Courses</h2>

<a href="/courses/new">Add Course</a>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Instructor</th>
</tr>

<c:forEach var="c" items="${courses}">
<tr>
    <td>${c.id}</td>
    <td>${c.name}</td>
    <td>${c.instructor}</td>
</tr>
</c:forEach>
</table>
