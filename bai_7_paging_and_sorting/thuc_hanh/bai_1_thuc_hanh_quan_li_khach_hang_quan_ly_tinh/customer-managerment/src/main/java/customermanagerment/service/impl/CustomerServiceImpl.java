package customermanagerment.service.impl;

import customermanagerment.model.Customer;
import customermanagerment.model.Province;
import customermanagerment.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public Province findCustomerById(Long id) {
        return null;
    }
}
