package com.model;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TPCValidation {
	public static void main(String[] args) {
		ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
		Validator validator=validatorFactory.getValidator();
		
		
		Person validPerson1= new Person("Shiva","Nellai Street,Karur");
		Customer validPerson2= new Customer("Shravan","Nehru Street,Madurai","shiva123@gmail.com","Regular","8778580344");
		
		Employee validPerson3= new Employee("Adithi", 10000, LocalDate.of(2020, 10, 07),"CEO","Gandhi street, Chennai");
		Set<ConstraintViolation<Person>> violations = validator.validate(validPerson1);

		violations =validator.validate(validPerson1);
		if(violations.isEmpty()) {
			savePerson(validPerson1);
			System.out.println("Valid person data provided.");
			
			}
		else {
			System.out.println("Invalid person data found.");
			for(ConstraintViolation<Person> violation:violations) {
				System.out.println(violation.getMessage());
			}
	}
		Set<ConstraintViolation<Customer>> violations1 = validator.validate(validPerson2);

		violations1 =validator.validate(validPerson2);
		if(violations1.isEmpty()) {
			savePerson(validPerson2);
			System.out.println("Valid Customer data provided.");
			
			}
		else {
			System.out.println("Invalid customer data found.");
			for(ConstraintViolation<Customer> violation:violations1) {
				System.out.println(violation.getMessage());
			}
	}
		Set<ConstraintViolation<Employee>> violations2 = validator.validate(validPerson3);

		violations2 =validator.validate(validPerson3);
		if(violations2.isEmpty()) {
			savePerson(validPerson3);
			System.out.println("Valid employee data provided.");
			
			}
		else {
			System.out.println("Invalid employee data found.");
			for(ConstraintViolation<Employee> violation:violations2) {
				System.out.println(violation.getMessage());
			}
			
	}
		
}
	public static void savePerson(Person person) {
		
		SessionFactory factory=HBUtil.getSessionFactory();
		Session session=factory.openSession();
		
		Transaction transaction =null;
		try {
			transaction = session.beginTransaction();
	        session.save(person);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		}
}
