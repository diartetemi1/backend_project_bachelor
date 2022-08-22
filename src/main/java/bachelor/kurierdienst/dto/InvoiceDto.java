package bachelor.kurierdienst.dto;

import java.sql.Date;

public class InvoiceDto {

    private Date datum;
    private Float endBetrag;
    private Integer customerId;
    private Integer[] tripsIds;

    public InvoiceDto(){}

    public InvoiceDto(Date datum, Float endBetrag, Integer customerId, Integer[] tripsIds) {
        this.datum = datum;
        this.endBetrag = endBetrag;
        this.customerId = customerId;
        this.tripsIds = tripsIds;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Float getEndBetrag() {
        return endBetrag;
    }

    public void setEndBetrag(Float endBetrag) {
        this.endBetrag = endBetrag;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer[] getTripsIds() {
        return tripsIds;
    }

    public void setTripsIds(Integer[] tripsIds) {
        this.tripsIds = tripsIds;
    }
}
