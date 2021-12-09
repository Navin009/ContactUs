import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./contactus.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ContactUsDao dao = new ContactUsDao();
        boolean isInserted = dao.insertContactUs(name, email, message);

        PrintWriter out = response.getWriter();
        if (isInserted) {
            out.println("<script>alert('Data Submitted!'); window.location.replace('./contactus');</script> ");

        } else {
            out.println("<script>alert('Data Not Submitted!'); window.location.replace('./contactus')</script> ");
        }
    }

}
