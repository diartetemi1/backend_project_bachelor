package bachelor.kurierdienst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bachelor.kurierdienst.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
