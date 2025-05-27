<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
</head>
<body>
<h1>Create Course</h1>
<form action="/users/${.vars['user-id']}/courses" method="post">
    <input type="text" name="title" placeholder="Title" required>
    <input type="text" name="level" placeholder="Level" required>
    <button type="submit">Create</button>
</form>

<h2>Your Courses</h2>
<h2>Courses of User #${.vars['user-id']}</h2>
<table>
    <tr>
        <th>Title</th>
        <th>Level</th>
        <th>Author</th>
    </tr>
    <#list courses as course>
        <tr>
            <td>${course.title}</td>
            <td>${course.level}</td>
            <td>${course.authorLogin}</td>
        </tr>
    </#list>
</table>
</body>
</html>