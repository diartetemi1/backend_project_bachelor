package bachelor.kurierdienst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

import jakarta.persistence.*;

@Table(name = "trip")
@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Integer jobID;

  @JsonIgnore
  @ManyToOne
  private Invoice invoice;

	@JsonIgnoreProperties("trips")
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private CourierDriver courierDriver;

	@JsonIgnoreProperties({"trips","invoices"})
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "datum")
	private Date datum;

	@Column(name = "orderer")
	private String orderer;

	@Column(name = "start_adress")
	private String startAdress;

	@Column(name = "finishing_point")
	private String finishingPoint;

	@Column(name = "fahrzeugart")
	private String fahrzeugart;

	@Column(name = "Entfernung")
	private float entfernung;

	@Column(name = "servicezeit")
	private float serviceZeit;

	@Column(name = "Nettopreis")
	private float nettoPreis;

	public Trip() {

	}

	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public CourierDriver getCourierDriver() {
		return courierDriver;
	}

	public void setCourierDriver(CourierDriver courierDriver) {
		this.courierDriver = courierDriver;
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

	public Integer getJobID() {
		return jobID;
	}

	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}

	public String getOrderer() {
		return orderer;
	}

	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}

	public String getStartAdress() {
		return startAdress;
	}

	public void setStartAdress(String startAdress) {
		this.startAdress = startAdress;
	}

	public String getFinishingPoint() {
		return finishingPoint;
	}

	public void setFinishingPoint(String finishingPoint) {
		this.finishingPoint = finishingPoint;
	}

	public String getFahrzeugart() {
		return fahrzeugart;
	}

	public void setFahrzeugart(String fahrzeugart) {
		this.fahrzeugart = fahrzeugart;
	}

	public float getEntfernung() {
		return entfernung;
	}

	public void setEntfernung(float entfernung) {
		this.entfernung = entfernung;
	}

	public float getServiceZeit() {
		return serviceZeit;
	}

	public void setServiceZeit(float serviceZeit) {
		this.serviceZeit = serviceZeit;
	}

	public float getNettoPreis() {
		return nettoPreis;
	}

	public void setNettoPreis(float nettoPreis) {
		this.nettoPreis = nettoPreis;
	}


	public Trip(Date datum, String orderer, String startAdress, String finishingPoint,
			String fahrzeugart, float entfernung, float serviceZeit, float nettoPreis,
				CourierDriver courierDriver, Customer customer) {
		this.courierDriver = courierDriver;
		this.customer = customer;
		this.datum = datum;
		this.orderer = orderer;
		this.startAdress = startAdress;
		this.finishingPoint = finishingPoint;
		this.fahrzeugart = fahrzeugart;
		this.entfernung = entfernung;
		this.serviceZeit = serviceZeit;
		this.nettoPreis = nettoPreis;
	}

}
