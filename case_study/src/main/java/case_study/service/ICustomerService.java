package case_study.service;

import case_study.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);


    Customer findById(Long id);

    void delete(Long id);

}
