package service;

import base.BaseService;
import domain.ComService;
import domain.Company;

import java.util.Date;
import java.util.List;

public interface ComServiceService extends BaseService<ComService> {
    List<ComService> findByOriginAndDestination(String origin, String destination);
    List<ComService> searchServiceByOriginAndDestination(String origin, String destination);
    ComService addNewService(Company company, String originCity, String destinationCity, int emptySeats, int price, Date dateAndTime);
}

