package util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class HtmlString {
    private String loginPageErrMsg = "";
    private String loginPage = "";
    private String companySignupPageErrMsg = "";
    private String companySignupPage = "";
    private String PassengerSignupPageErrMsg = "";
    private String PassengerSignupPage = "";
    private String companyMenuErrMsg = "";
    private String companyMenu = "";
    private String passengerMenuErrMsg = "";
    private String passengerMenu = "";


    public String getLoginPageErrMsg() {
        return loginPageErrMsg;
    }

    public void setLoginPageErrMsg(String loginPageErrMsg) {
        this.loginPageErrMsg = loginPageErrMsg;
    }

    public String getLoginPage() {
        return "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Online ticket project</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <p><b>Welcome To Online Ticket Project</b></p>\n" +
                "    <form action=\"http://localhost:8080/OnlineTicketWebApp_war_exploded/login\" method=\"POST\" name=\"login\">\n" +
                "        <input type=\"text\" name=\"username\" placeholder=\"username\" required><br>\n" +
                "        <input type=\"password\" name=\"password\" placeholder=\"password\" required><br>\n" +
                "        <input type=\"submit\" value=\"login\"><br>\n" +
                getLoginPageErrMsg() +
                "        <input type=\"radio\" name=\"usertype\" value=\"costumer\" required>costumer<br>\n" +
                "        <input type=\"radio\" name=\"usertype\" value=\"company\" required>company<br>\n" +
                "        <a href=\"http://localhost:8080/OnlineTicketWebApp_war_exploded/companysignup\">signup as company</a><br>\n" +
                "<a href=\"http://localhost:8080/OnlineTicketWebApp_war_exploded/passengersignup\">signup as costumer</a>\n" +
                "    </form>\n" +
                "\n" +
                "</body>";
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getCompanySignupPage() {
        return "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>sign up as company</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"http://localhost:8080/OnlineTicketWebApp_war_exploded/companysignup\"\n" +
                "          method=\"post\" name=\"company-signup-form\">\n" +
                "        <input type=\"text\" name=\"companyname\" placeholder=\"company name\" required><br>\n" +
                "        <input type=\"text\" name=\"companyusername\" placeholder=\"username\" required><br>\n" +
                "        <input type=\"password\" name=\"companypassword\" placeholder=\"password\" required><br>\n" +
                "        <input type=\"password\" name=\"companypasswordrepeat\" placeholder=\"repeat password\" required><br>\n" +
                "        <input type=\"submit\" value=\"signup\"><br>\n" +
                "    </form>\n" +
                getCompanySignupPageErrMsg() +
                "</body>";
    }

    public void setCompanySignupPage(String companySignupPage) {
        this.companySignupPage = companySignupPage;
    }

    public String getCompanySignupPageErrMsg() {
        return companySignupPageErrMsg;
    }

    public void setCompanySignupPageErrMsg(String companySignupPageErrMsg) {
        this.companySignupPageErrMsg = companySignupPageErrMsg;
    }

    public String getPassengerSignupPageErrMsg() {
        return PassengerSignupPageErrMsg;
    }

    public void setPassengerSignupPageErrMsg(String passengerSignupPageErrMsg) {
        PassengerSignupPageErrMsg = passengerSignupPageErrMsg;
    }

    public String getPassengerSignupPage() {
        return "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>sign up as costumer</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"http://localhost:8080/OnlineTicketWebApp_war_exploded/passengersignup\" method=\"post\" name=\"passenger-signup-form\">\n" +
                "        <input type=\"text\" name=\"fname\" placeholder=\"first name\" required><br>\n" +
                "        <input type=\"text\" name=\"lname\" placeholder=\"last name\" required><br>\n" +
                "        <input type=\"text\" name=\"username\" placeholder=\"username\" required><br>\n" +
                "        <input type=\"password\" name=\"password\" placeholder=\"password\" required><br>\n" +
                "        <input type=\"password\" name=\"repeatpassword\" placeholder=\"repeat password\" required><br>\n" +
                "        <input type=\"submit\" value=\"signup\">\n" +
                "    </form>\n" +
                getPassengerSignupPageErrMsg() +
                "</body>";
    }

    public void setPassengerSignupPage(String passengerSignupPage) {
        PassengerSignupPage = passengerSignupPage;
    }

    public String getCompanyMenuErrMsg() {
        return companyMenuErrMsg;
    }

    public void setCompanyMenuErrMsg(String companyMenuErrMsg) {
        this.companyMenuErrMsg = companyMenuErrMsg;
    }

    public String getCompanyMenu() {
        return "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Company Menu</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h2>add service</h2><br>\n" +
                "    <form action=\"http://localhost:8080/OnlineTicketWebApp_war_exploded/companymenu\" method=\"post\" name=\"add-service-form\">\n" +
                "        <input type=\"text\" name=\"origincity\" placeholder=\"origin city\" required><br>\n" +
                "        <input type=\"text\" name=\"destionationcity\" placeholder=\"destination city\" required><br>\n" +
                "        <input type=\"number\" name=\"emptyseats\" placeholder=\"number of empty seats\" required><br>\n" +
                "        <input type=\"number\" name=\"price\" placeholder=\"price\" required><br>\n" +
                "        <input type=\"datetime-local\" name=\"datetime\" placeholder=\"date & time of Departure\" required><br>\n" +
                "        <input type=\"submit\" value=\"add\"><br>\n" +
                "    </form>\n" +
                getCompanyMenuErrMsg() +
                "</body>";
    }

    public void setCompanyMenu(String companyMenu) {
        this.companyMenu = companyMenu;
    }

    public String getPassengerMenu() {
        return "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>user menu</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h2>enter origin and destination to find ticket</h2>\n" +
                "    <form action=\"http://localhost:8080/OnlineTicketWebApp_war_exploded/passengermenu\" method=\"POST\">\n" +
                "        <input type=\"text\" name=\"origincity\" placeholder=\"enter origin city\" required>\n" +
                "        <input type=\"text\" name=\"destinationcity\" placeholder=\"enter destination city\" required><br>\n" +
                "        <label for=\"sCompany\">sort by company</label>\n" +
                "        <input type=\"radio\" id=\"sCompany\" name=\"sort\" value=\"c\">\n" +
                "        <label for=\"sDestination\">sort by destination</label>\n" +
                "        <input type=\"radio\" id=\"sDestination\" name=\"sort\" value=\"d\">\n" +
                "        <label for=\"sOrigin\">sort by origin city</label>\n" +
                "        <input type=\"radio\" id=\"sOrigin\" name=\"sort\" value=\"o\">\n" +
                "        <label for=\"sPrice\">sort by price</label>\n" +
                "        <input type=\"radio\" id=\"sPrice\" name=\"sort\" value=\"p\"><br>" +
                "       <input type=\"checkbox\" id=\"rev\" name=\"reverse\">\n" +
                "       <label for=\"rev\">reverse</label><br>" +
                "        <input type=\"submit\" value=\"find\">\n" +
                "    </form><br>\n" +
                getPassengerMenuErrMsg() +
                "</body>";
    }

    public void setPassengerMenu(String passengerMenu) {
        this.passengerMenu = passengerMenu;
    }

    public String getPassengerMenuErrMsg() {
        return passengerMenuErrMsg;
    }

    public void setPassengerMenuErrMsg(String passengerMenuErrMsg) {
        this.passengerMenuErrMsg = passengerMenuErrMsg;
    }
}
