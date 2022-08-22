package bachelor.kurierdienst.dto;

public class CustomerDto {

    private String name;
    private String email;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    public  CustomerDto(){}

    public CustomerDto(String name, String email, String address, String city, String postalCode, String country) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
