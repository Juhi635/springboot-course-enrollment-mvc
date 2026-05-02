<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Enrollments</h2>

<a href="/enrollments/new">Add Enrollment</a>

<table border="1">
<tr>
    <th>Student</th>
    <th>Email</th>
    <th>Course</th>
</tr>

<c:forEach var="e" items="${list}">
<tr>
    <td>${e.studentName}</td>
    <td>${e.email}</td>
    <td>${e.course.name}</td>
</tr>
</c:forEach>
</table>
