package view;

import org.hibernate.type.LocalDateTimeType;
import util.AppContext;
import util.HtmlString;
import util.Menu;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;

public class CompanyMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        showPage(resp, "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String origin = req.getParameter("origincity"), destination = req.getParameter("destionationcity");
        int emptyseats = Integer.parseInt(req.getParameter("emptyseats")), price = Integer.parseInt(req.getParameter("price"));
        Date dateAndTime = Menu.dateAndTimeConvertor(req.getParameter("datetime"));

        if(Objects.equals(origin, destination)){
            showPage(resp, "<p>origin and destination can not be the same!!!</p>");
        } else {
            assert dateAndTime != null;
            if (dateAndTime.compareTo(new Date()) < 0 || dateAndTime.compareTo(new Date()) == 0) {
                showPage(resp, "<p>wrong Time entry!!!</p>");
            } else {
                AppContext.comServiceService.addNewService(AppContext.getCurrentCompany(), origin, destination,
                        emptyseats, price, dateAndTime);
                showPage(resp, "<p>service added...</p>");
            }
        }
    }

    private void showPage(HttpServletResponse resp, String msg) {
        HtmlString htmlString = new HtmlString();
        htmlString.setCompanyMenuErrMsg(msg);
        resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            out.println(htmlString.getCompanyMenu());
            out.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
