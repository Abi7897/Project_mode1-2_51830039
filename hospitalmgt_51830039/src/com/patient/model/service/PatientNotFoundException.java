package com.patient.model.service;

public class PatientNotFoundException extends RuntimeException{
	public PatientNotFoundException (String message){
		super(message);
	}

}
