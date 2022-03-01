package customermanagerment.service;

import customermanagerment.model.Customer;
import customermanagerment.model.Province;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    Province findCustomerById(Long id);
}
