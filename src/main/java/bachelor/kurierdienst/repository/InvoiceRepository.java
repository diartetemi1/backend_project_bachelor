package bachelor.kurierdienst.repository;

import bachelor.kurierdienst.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
