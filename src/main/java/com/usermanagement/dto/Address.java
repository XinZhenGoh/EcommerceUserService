package com.usermanagement.dto;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address{
	String city;
	String state;
	Integer zipcode;
}
