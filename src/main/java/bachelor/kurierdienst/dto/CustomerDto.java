package bachelor.kurierdienst.dto;

import lombok.Value;

@Value
public class CustomerDto {

    String name;
    String email;
    String address;
    String city;
    String postalCode;
    String country;
}
