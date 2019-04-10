package vn.sapo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.sapo.domain.Customer;
import vn.sapo.repository.CustomerRepository;
import vn.sapo.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        log.debug("findAll");
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(String id) {
        log.debug("findById : {}", id);
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        log.debug("save");
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(String id) {
        log.debug("deleteById : {}", id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        log.debug("findByName : {}", name);
        return customerRepository.findByName(name);
    }

    @Override
    public List<Customer> findByNameLike(String name) {
        log.debug("findByNameLike : {}", name);
        return customerRepository.findByNameLike(name);
    }

}
