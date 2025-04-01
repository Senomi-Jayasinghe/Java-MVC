<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bookPackage.Book, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Book List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .create-button {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h2>Book List</h2>

    <!-- Create New Book Button -->
    <a href="bookDetails.jsp">
        <button class="create-button">Create New Book</button>
    </a>

    <table>
        <thead>
            <tr>
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Book> books = (List<Book>) request.getAttribute("books");
                if (books != null && !books.isEmpty()) {
                    for (Book book : books) { 
            %>
                <tr>
                    <td><%= book.getBookID() %></td>
                    <td><%= book.getBookName() %></td>
                    <td>
                        <a href="viewBook?id=<%= book.getBookID() %>">View</a> |
                        <a href="editBook?id=<%= book.getBookID() %>">Edit</a> |
                        <a href="deleteBook?id=<%= book.getBookID() %>" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            <% 
                    } 
                } else { 
            %>
                <tr>
                    <td colspan="3">No books found.</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>