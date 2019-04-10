package vn.sapo.service;

import vn.sapo.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Optional<Customer> findById (String id);

    void save (Customer customer);

    void deleteById (String id);

    List<Customer> findByName (String name);

    List<Customer> findByNameLike (String name);

}
