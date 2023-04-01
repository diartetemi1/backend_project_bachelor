package bachelor.kurierdienst.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class CourierDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Integer driverID;

    @JsonIgnoreProperties({"courierDriver", "customer"})
    @OneToMany(mappedBy = "courierDriver", cascade = CascadeType.ALL)
    private List<Trip> trips = new ArrayList<>();

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    //@Size(max = 20)
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

}
