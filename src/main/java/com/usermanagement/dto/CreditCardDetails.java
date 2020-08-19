package com.usermanagement.dto;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CreditCardDetails {

	String name;
	String creditCard; //display last 4 digits..
	LocalDate expirationDate;
	
}
