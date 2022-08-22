package bachelor.kurierdienst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bachelor.kurierdienst.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
