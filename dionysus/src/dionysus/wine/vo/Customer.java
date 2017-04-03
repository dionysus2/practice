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
       private int basicInfoId;
	public Customer(String customerRrn, String customerAddress, String customerName, String customerTel,
			String customerGender, String customerAccountNo, String customerJob, int basicInfoId) {
		super();
		this.customerRrn = customerRrn;
		this.customerAddress = customerAddress;
		this.customerName = customerName;
		this.customerTel = customerTel;
		this.customerGender = customerGender;
		this.customerAccountNo = customerAccountNo;
		this.customerJob = customerJob;
		this.basicInfoId = basicInfoId;
	}
}
