package dionysus.wine.vo;

import lombok.Data;

@Data
public class Customer {
       private int customerId;
       private String customerRrn;
       private String customerAddress;
       private String customerName;
       private String customerTel;
       private String customerGender;
       private String customerAccountNo;
       private String customerJob;
       private String customerActivated;
       private String basicInfoId;
}
