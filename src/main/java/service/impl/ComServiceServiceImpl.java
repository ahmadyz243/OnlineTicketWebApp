package service.impl;

import base.BaseServiceImpl;
import domain.ComService;
import domain.Company;
import repository.ComServiceRepository;
import service.ComServiceService;
import util.Menu;

import java.util.Date;
import java.util.List;

public class ComServiceServiceImpl extends BaseServiceImpl<ComService, ComServiceRepository> implements ComServiceService {
    public ComServiceServiceImpl(ComServiceRepository repository) {
        super(repository);
    }



    @Override
    public List<ComService> findByOriginAndDestination(String origin, String destination) {
        return repository.findByOriginAndDestination(origin, destination);
    }

    @Override
    public List<ComService> searchServiceByOriginAndDestination(String origin, String destination) {
        List<ComService> services = findByOriginAndDestination(origin, destination);
        if(services.size() == 0){
            return null;
        }else {
            return services;
        }
    }

    @Override
    public ComService addNewService(Company company, String originCity, String destinationCity, int emptySeats, int price, Date dateAndTime) {
        ComService comService = new ComService(originCity, destinationCity, emptySeats, price, dateAndTime, company);
        company.getServices().add(comService);
        save(comService);
        return comService;
    }
}
