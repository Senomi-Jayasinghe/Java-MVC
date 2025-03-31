<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h2>Add a New Book</h2>
    <form action="BookServlet" method="post">
        <label for="bookName">Book Name:</label>
        <input type="text" id="bookName" name="bookName" required>
        <button type="submit">Add Book</button>
    </form>
</body>
</html>