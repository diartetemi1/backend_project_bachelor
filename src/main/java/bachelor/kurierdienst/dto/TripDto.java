package bachelor.kurierdienst.dto;

import lombok.Value;

import java.sql.Date;

@Value
public class TripDto {

    Date datum;
    String orderer;
    String startAdress;
    String finishingPoint;
    String fahrzeugart;
    Float entfernung;
    Float serviceZeit;
    Float nettoPreis;
    Integer courierDriverId;
    Integer customerId;

}
