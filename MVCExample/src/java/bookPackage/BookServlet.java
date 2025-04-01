package bookPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bookPackage.Book;
import bookPackage.DbConnection;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = new ArrayList<>();

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tblbook");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getInt("BookID"));
                book.setBookName(rs.getString("BookName"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("books", books);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String bookName = request.getParameter("bookName");
        //INSERT
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO tblbook (BookName) VALUES (?)")) {

            stmt.setString(1, bookName);
            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
