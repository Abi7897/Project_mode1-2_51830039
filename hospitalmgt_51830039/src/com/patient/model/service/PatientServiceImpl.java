package com.patient.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.patient.model.persistance.Patient;
import com.patient.model.persistance.PatientDao;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao dao;

	@Override
	public List<Patient> getAllpatients() {
		
		return dao.getAllpatients();
	}

	@Override
	public Patient getPatientById(int patientId) {
		Patient patient=dao.getPatientById(patientId);
		if(patient==null)
			throw new PatientNotFoundException("customer with id:"+patientId+"is not found");
		return patient;
	}

	@Override
	public Patient addPatient(Patient patient) {
		
		return dao.addPatient(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		
		return dao.updatePatient(patient);
	}

	@Override
	public Patient removePatient(int patientId) {
		
		return dao.removePatient(patientId);
	}
	

}
