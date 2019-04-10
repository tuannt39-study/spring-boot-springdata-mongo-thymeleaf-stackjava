package vn.sapo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.sapo.domain.Customer;
import vn.sapo.repository.CustomerRepository;
import vn.sapo.service.CustomerService;

import java.util.Optional;

@Controller
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = {"/", "/customer-list"})
    public String listCustomer(Model model) {
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }

    @RequestMapping("/customer-save")
    public String insertCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-save";
    }

    @RequestMapping("/customer-view/{id}")
    public String viewCustomer(@PathVariable String id, Model model) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        }
        return "customer-view";
    }

    @RequestMapping("/customer-update/{id}")
    public String updateCustomer(@PathVariable String id, Model model) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        }
        return "customer-update";
    }

    @RequestMapping("/saveCustomer")
    public String doSaveCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
        customerRepository.save(customer);
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }

    @RequestMapping("/updateCustomer")
    public String doUpdateCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
        customerRepository.save(customer);
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }

    @RequestMapping("/customerDelete/{id}")
    public String doDeleteCustomer(@PathVariable String id, Model model) {
        customerRepository.deleteById(id);
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }
}
