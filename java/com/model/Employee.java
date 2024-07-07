package com.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@DiscriminatorValue(value="Employee_details")
public class Employee extends Person{
	 @NotBlank(message = "Designation is required")
	 private String designation;
	
	 @Min(value = 0, message = "Salary must be greater than or equal to 0")
	    private float salary;
  
	 @Temporal(TemporalType.DATE)
	   private LocalDate dtOfJoining;
   public Employee(String name, float salary , LocalDate dateOfJoining , String designation , String email) {
		super(name, email);
		this.dtOfJoining = dateOfJoining  ;
		this.designation = designation  ;
		
		this.salary =salary;
	}  
   public String getDestination() {
		return designation;
	}
	public void setDestination(String destination) {
		this.designation = destination;
	}
	public LocalDate getDtOfJoining() {
		return dtOfJoining;
	}
	public void setDtOfJoining(LocalDate dtOfJoining) {
		this.dtOfJoining = dtOfJoining;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	   
}
