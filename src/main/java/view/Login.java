package view;

import base.BaseView;
import domain.Company;
import domain.Passenger;
import repository.impl.CompanyRepositoryImpl;
import service.CompanyService;
import service.impl.CompanyServiceImpl;
import util.AppContext;
import util.HtmlString;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HtmlString htmlString = new HtmlString();
        resp.setContentType("text/html");
        PrintWriter out;
        try {
            out = resp.getWriter();
            out.println(htmlString.getLoginPage());
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HtmlString htmlString = new HtmlString();
        String username = req.getParameter("username"), password = req.getParameter("password"), usertype = req.getParameter("usertype");

        if (Objects.equals(usertype, "costumer")) {
            Passenger passenger = AppContext.passengerService.login(username, password);
            if (passenger == null) {
                htmlString.setLoginPageErrMsg("<p>wrong username or password</p>\n");
                try {
                    PrintWriter out = resp.getWriter();
                    out.println(htmlString.getLoginPage());
                    out.close();
                } catch (IOException b) {
                    System.out.println(b.getMessage());
                }
            }else {
                resp.sendRedirect("http://localhost:8080/OnlineTicketWebApp_war_exploded/passengermenu");
            }
        } else if (Objects.equals(usertype, "company")) {
            //login company
            Company company = AppContext.companyService.login(username, password);
            AppContext.setCurrentCompany(company);
            if(company == null){
                htmlString.setLoginPageErrMsg("<p>wrong username or password</p>\n");
                try {
                    PrintWriter out = resp.getWriter();
                    out.println(htmlString.getLoginPage());
                    out.close();
                } catch (IOException b) {
                    System.out.println(b.getMessage());
                }
            }else {
                resp.sendRedirect("http://localhost:8080/OnlineTicketWebApp_war_exploded/companymenu");
            }
        }
    }
}
