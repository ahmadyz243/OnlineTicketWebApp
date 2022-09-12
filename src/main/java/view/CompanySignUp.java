package view;
import domain.Company;
import util.AppContext;
import util.HtmlString;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class CompanySignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(resp, "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HtmlString htmlString = new HtmlString();
        String companyName = req.getParameter("companyname"), username = req.getParameter("companyusername")
                , password = req.getParameter("companypassword"), repeat = req.getParameter("companypasswordrepeat");

        if(!Objects.equals(password, repeat)){
            showPage(resp, "<p>repeat password carefully!</p>");
        }else {
            Company company = AppContext.companyService.signup(companyName, username, password);
            if(company == null){
                htmlString.setCompanySignupPageErrMsg("<p>company already exists!!!</p>\n");
                try {
                    PrintWriter out = resp.getWriter();
                    out.println(htmlString.getCompanySignupPage());
                    out.close();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }else{
                resp.sendRedirect("http://localhost:8080/OnlineTicketWebApp_war_exploded/login");
            }
        }
    }

    private void showPage(HttpServletResponse resp, String msg) {
        HtmlString htmlString = new HtmlString();
        htmlString.setCompanySignupPageErrMsg(msg);
        try {
            resp.setContentType("text/html");
            PrintWriter p = resp.getWriter();
            p.println(htmlString.getCompanySignupPage());
            p.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
