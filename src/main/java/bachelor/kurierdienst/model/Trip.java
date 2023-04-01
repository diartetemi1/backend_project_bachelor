package bachelor.kurierdienst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
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

    @JsonIgnoreProperties({"trips", "invoices"})
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

}
