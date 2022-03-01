package customermanagement.service;

import customermanagement.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);

    List<Customer> findByName(String name);
}
