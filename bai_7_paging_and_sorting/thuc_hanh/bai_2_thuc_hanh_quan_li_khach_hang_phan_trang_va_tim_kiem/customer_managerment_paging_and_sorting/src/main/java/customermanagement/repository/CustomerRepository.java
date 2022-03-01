package customermanagement.repository;

import customermanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAll(Pageable pageable);

/*    List<Customer> findAllByNameContaining(String name);*/
    //Query
    // native = true - sql - native
    // = false - hql - jpql
    @Query(value = "select * from customer where firstName like %?%",nativeQuery = true)
    List<Customer> findByName(String name);
}
