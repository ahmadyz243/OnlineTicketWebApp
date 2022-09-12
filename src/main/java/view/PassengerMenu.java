package view;

import comprators.SortByCompany;
import comprators.SortByDestination;
import comprators.SortByOrigin;
import comprators.SortByPrice;
import domain.ComService;
import util.AppContext;
import util.HtmlString;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PassengerMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HtmlString htmlString = new HtmlString();
        resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            out.println(htmlString.getPassengerMenu());
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String origin = req.getParameter("origincity"), destination = req.getParameter("destinationcity"),
                sort = req.getParameter("sort"), rev = req.getParameter("reverse");

        List<ComService> services = AppContext.comServiceService.searchServiceByOriginAndDestination(origin, destination);

        if(services == null){
            showPage(resp, "no service found!!!");
        }else {
            if(Objects.equals(sort, "c")){
                services.sort(new SortByCompany());
            } else if (Objects.equals(sort, "d")) {
                services.sort(new SortByDestination());
            } else if (Objects.equals(sort, "o")) {
                services.sort(new SortByOrigin());
            } else if (Objects.equals(sort, "p")) {
                services.sort(new SortByPrice());
            }

            if(rev != null){
                Collections.reverse(services);
            }

            showPage(resp, createTableCodeHtml(services));
        }

    }



    private String createTableCodeHtml(List<ComService> services) {
        String table = "<table border=\"2\">\n" +
                "        <tr>\n" +
                "            <th>origin</th>\n" +
                "            <th>destination</th>\n" +
                "            <th>price</th>\n" +
                "            <th>empty seats</th>\n" +
                "            <th>company name</th>\n" +
                "            <th>date and time</th>\n" +
                "        </tr>\n";

        for (ComService service : services) {
            table = table.concat("<tr>\n" + "<td>" + service.getOriginCity() + "</td>\n" +
                    "<td>" + service.getDestinationCity() + "</td>\n" +
                    "<td>" + service.getPrice() + "</td>\n" +
                    "<td>" + service.getEmptySeats() + "</td>\n" +
                    "<td>" + service.getCompany().getName() + "</td>\n" +
                    "<td>" + service.getDateAndTimeOfDeparture() + "</td>\n" +
                    "</tr>\n");
        }
        table = table.concat("</table>");
        return table;
    }

    private void showPage(HttpServletResponse response, String msg) {
        HtmlString htm = new HtmlString();
        htm.setPassengerMenuErrMsg(msg);
        try {
            PrintWriter out = response.getWriter();
            out.println(htm.getPassengerMenu());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
