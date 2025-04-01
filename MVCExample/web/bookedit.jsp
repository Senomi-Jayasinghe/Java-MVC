<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bookPackage.Book" %>
<%@page import="java.util.List" %>

<%
    // Get the book object from request
    Book book = (Book) request.getAttribute("book");

    if (book == null) {
        response.sendRedirect("index.jsp"); // Redirect if book is not found
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Book</title>
</head>
<body>
    <h2>Edit Book</h2>
    <form action="BookServlet" method="post">
        <input type="hidden" name="bookID" value="<%= book.getBookID() %>">
        
        <label for="bookName">Book Name:</label>
        <input type="text" id="bookName" name="bookName" value="<%= book.getBookName() %>" required>
        
        <button type="submit">Update Book</button>
    </form>
</body>
</html>