package service;

import base.BaseService;
import domain.Passenger;

public interface PassengerService extends BaseService<Passenger> {
    boolean existsByUsername(String username);
    Passenger findByUsername(String username);
    Passenger signup(String firstname, String lastname, String username, String password);
    Passenger login(String username, String password);
}