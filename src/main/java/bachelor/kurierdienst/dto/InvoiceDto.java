package bachelor.kurierdienst.dto;

import lombok.Value;

import java.sql.Date;

@Value
public class InvoiceDto {

    Date datum;
    Float endBetrag;
    Integer customerId;
    Integer[] tripsIds;

}
