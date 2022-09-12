package view;

import domain.Passenger;
import util.AppContext;
import util.HtmlString;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class PassengerSignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        showPage(resp, "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HtmlString htmlString = new HtmlString();
        String firstname = req.getParameter("fname"), lastname = req.getParameter("lname"), username = req.getParameter("username"),
                password = req.getParameter("password"), repeatpassword = req.getParameter("repeatpassword");

        if (!Objects.equals(password, repeatpassword)) {
            showPage(resp, "<p>repeat password carefully</p>");
        } else {
            Passenger passenger = AppContext.passengerService.signup(firstname, lastname, username, password);
            if (passenger == null) {
                showPage(resp, "<p>username already exists!!!</p>");
            } else {
                resp.sendRedirect("http://localhost:8080/OnlineTicketWebApp_war_exploded/login");
            }
        }
    }

    private void showPage(HttpServletResponse resp, String msg) {
        HtmlString htmlString = new HtmlString();
        htmlString.setPassengerSignupPageErrMsg(msg);
        resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            out.println(htmlString.getPassengerSignupPage());
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
