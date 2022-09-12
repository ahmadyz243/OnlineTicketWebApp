package util;

import domain.ComService;
import domain.Company;
import repository.impl.ComServiceRepositoryImpl;
import repository.impl.CompanyRepositoryImpl;
import repository.impl.PassengerRepositoryImpl;
import service.ComServiceService;
import service.CompanyService;
import service.PassengerService;
import service.impl.ComServiceServiceImpl;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;

public class AppContext {

    private static Company currentCompany;
    public static CompanyService companyService= new CompanyServiceImpl(new CompanyRepositoryImpl());
    public static PassengerService passengerService = new PassengerServiceImpl(new PassengerRepositoryImpl());
    public static ComServiceService comServiceService = new ComServiceServiceImpl(new ComServiceRepositoryImpl());

    public static Company getCurrentCompany() {
        return currentCompany;
    }

    public static void setCurrentCompany(Company currentCompany) {
        AppContext.currentCompany = currentCompany;
    }
}
