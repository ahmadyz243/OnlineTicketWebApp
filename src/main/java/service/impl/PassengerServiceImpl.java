package service.impl;

import base.BaseServiceImpl;
import domain.Company;
import domain.Passenger;
import repository.PassengerRepository;
import service.PassengerService;
import util.Menu;

import java.util.Objects;

public class PassengerServiceImpl extends BaseServiceImpl<Passenger, PassengerRepository> implements PassengerService {
    public PassengerServiceImpl(PassengerRepository repository) {
        super(repository);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Passenger findByUsername(String username) {
        return repository.findByUsername(username);
    }



    @Override
    public Passenger signup(String firstname, String lastname, String username, String password) {
        if (existsByUsername(username)){
            return null;
        }
        Passenger passenger = new Passenger();
        passenger.setFirstName(firstname);
        passenger.setLastName(lastname);
        passenger.setUserName(username);
        passenger.setPassword(password);
        save(passenger);
        return passenger;
    }

    @Override
    public Passenger login(String username, String password) {
        Passenger passenger;
        if(existsByUsername(username)){
            passenger = findByUsername(username);
        }else {
            System.out.println("costumer not exists!");
            return null;
        }
        if (Objects.equals(passenger.getPassword(), password)){
            System.out.println("login success...");
            return passenger;
        }else {
            System.out.println("wrong password");
            return null;
        }
    }
}
