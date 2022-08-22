package bachelor.kurierdienst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bachelor.kurierdienst.model.CourierDriver;

@Repository
public interface CourierDriverRepository extends JpaRepository<CourierDriver, Integer>{

}
