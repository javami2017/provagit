package jsp_jsf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] arr = { "nina", "pinta", "santa maria" };
        req.getSession().setAttribute("stringhe", arr);
        
        RequestDispatcher view = req.getRequestDispatcher("output.jsp");
        view.forward(req, resp);
    }

}
