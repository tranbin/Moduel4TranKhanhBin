package customermanagerment.controller;

import customermanagerment.model.Customer;
import customermanagerment.model.Province;

import customermanagerment.service.impl.CustomerServiceImpl;
import customermanagerment.service.impl.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ProvinceServiceImpl provinceService;

    @GetMapping("")
    public ModelAndView getIndex() {
        return new ModelAndView("customer/index", "customers", customerService.findAll());
    }

    @GetMapping("/customer/create-customer")
    public ModelAndView showCreateForm(Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return new ModelAndView("customer/create-customer", "customer", new Customer());
    }

    @PostMapping("/customer/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create-customer");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New Customer create successfully");
        return modelAndView;
    }

    @GetMapping("/customer/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        Customer customer = customerService.findCustomerById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("customer/edit-customer");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/customer/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/customer/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit-customer");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer update successfully");
        return modelAndView;
    }

    @GetMapping("/customer/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id, Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        Customer customer = customerService.findCustomerById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/customer/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/customer/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.deleteCustomer(customer.getId());
        return "customer/index";
    }

    @GetMapping("/customer/view-customer/{id}")
    public String viewCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "customer/view";
    }

    @GetMapping("/customer/search-customer")
    public String searchByName(@RequestParam("searchByName") String name, Model model) {
        List<Customer> customerList = customerService.findByName(name);
        model.addAttribute("customers", customerList);
        return "customer/index";
    }

}
