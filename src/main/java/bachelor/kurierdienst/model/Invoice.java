package bachelor.kurierdienst.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceID;

    @JsonIgnoreProperties("customer")
    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private List<Trip> trips = new ArrayList<Trip>();

    @JsonIgnoreProperties({"trips", "invoices"})
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "datum")
    private Date datum;

    @Column(name = "endbetrag")
    private float endBetrag;

}
