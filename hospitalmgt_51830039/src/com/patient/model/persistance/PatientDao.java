package com.patient.model.persistance;

import java.util.List;

public interface PatientDao {
	public List<Patient> getAllpatients();
	public Patient getPatientById(int patientId);
	public Patient addPatient(Patient patient);
	public Patient updatePatient(Patient patient);
	public Patient removePatient(int patientId);
}
