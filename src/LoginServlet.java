import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = { "/gicungduoc", "/urlnaocungduoc" })
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        // ket noi CSDL

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str1 = request.getParameter("axaxasd");
        String str2 = request.getParameter("adasdasd");

        PrintWriter writer = response.getWriter();
        writer.print("Da dang nhap thanh cong <br>");
        writer.print(str1 + "<br>");
        writer.print(str2 + "<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.print("Gi cung duoc");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
