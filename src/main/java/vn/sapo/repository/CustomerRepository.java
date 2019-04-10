package vn.sapo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import vn.sapo.domain.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{ 'name': ?0}")
    List<Customer> findByName(String name);

    List<Customer> findByNameLike(String name);

}
