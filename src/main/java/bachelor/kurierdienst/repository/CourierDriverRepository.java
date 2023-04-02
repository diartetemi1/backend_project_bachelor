package bachelor.kurierdienst.repository;

import bachelor.kurierdienst.model.CourierDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierDriverRepository extends JpaRepository<CourierDriver, Integer> {

}
