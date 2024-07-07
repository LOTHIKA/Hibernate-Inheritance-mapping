package com.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="Customer_details")
public class Customer extends Person{
	
	@Email(message="Invalid email address.Please enter a proper email ID.")
	@NotEmpty(message="Please enter your email ID.")
	private String email;
	
	 @NotBlank(message = "Customer type is required")
	 private String customerType;
         
         
	 @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	 private String mobileno;
        
		public Customer(String name, String address, String email, String customerType, String mobileno) {
			super(name, address);
			this.email = email;
			this.customerType = customerType;
			this.mobileno = mobileno;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCustomerType() {
			return customerType;
		}
		public void setCustomerType(String customerType) {
			this.customerType = customerType;
		}
		public String getMobileno() {
			return mobileno;
		}
		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}
         
         
}
