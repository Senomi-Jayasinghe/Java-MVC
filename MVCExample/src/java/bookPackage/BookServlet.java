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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String bookName = request.getParameter("bookName");

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
