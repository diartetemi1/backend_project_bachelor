package bachelor.kurierdienst.dto;

import java.sql.Date;

public class TripDto {

    private Date datum;
    private String orderer;
    private String startAdress;
    private String finishingPoint;
    private String fahrzeugart;
    private Float entfernung;
    private Float serviceZeit;
    private Float nettoPreis;
    private Integer courierDriverId;
    private Integer customerId;

    public TripDto(){}

    public TripDto(Date datum, String orderer, String startAdress, String finishingPoint, String fahrzeugart, Float entfernung, Float serviceZeit, Float nettoPreis, Integer courierDriverId, Integer customerId) {
        this.datum = datum;
        this.orderer = orderer;
        this.startAdress = startAdress;
        this.finishingPoint = finishingPoint;
        this.fahrzeugart = fahrzeugart;
        this.entfernung = entfernung;
        this.serviceZeit = serviceZeit;
        this.nettoPreis = nettoPreis;
        this.courierDriverId = courierDriverId;
        this.customerId = customerId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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

    public Float getEntfernung() {
        return entfernung;
    }

    public void setEntfernung(Float entfernung) {
        this.entfernung = entfernung;
    }

    public Float getServiceZeit() {
        return serviceZeit;
    }

    public void setServiceZeit(Float serviceZeit) {
        this.serviceZeit = serviceZeit;
    }

    public Float getNettoPreis() {
        return nettoPreis;
    }

    public void setNettoPreis(Float nettoPreis) {
        this.nettoPreis = nettoPreis;
    }

    public Integer getCourierDriverId() {
        return courierDriverId;
    }

    public void setCourierDriverId(Integer courierDriverId) {
        this.courierDriverId = courierDriverId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
