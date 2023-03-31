package bachelor.kurierdienst.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private Integer invoiceID;

	@JsonIgnoreProperties("customer")
	@OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
	private List<Trip> trips = new ArrayList<Trip>();

	@JsonIgnoreProperties({ "trips", "invoices" })
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "datum")
	private Date datum;

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	@Column(name = "endbetrag")
	private float endBetrag;

	public Invoice() {

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Integer getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}

	public float getEndBetrag() {
		return endBetrag;
	}

	public void setEndBetrag(float endBetrag) {
		this.endBetrag = endBetrag;
	}

	public Invoice(Date datum, float endBetrag, Customer customer) {
		this.customer = customer;
		this.datum = datum;
		this.endBetrag = endBetrag;
	}

}
