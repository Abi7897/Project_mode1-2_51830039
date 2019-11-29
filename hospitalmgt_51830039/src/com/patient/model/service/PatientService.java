package com.patient.model.service;

import java.util.List;

import com.patient.model.persistance.Patient;

public interface PatientService {
	public List<Patient> getAllpatients();
	public Patient getPatientById(int patientId);
	public Patient addPatient(Patient patient);
	public Patient updatePatient(Patient patient);
	public Patient removePatient(int patientId);
}
