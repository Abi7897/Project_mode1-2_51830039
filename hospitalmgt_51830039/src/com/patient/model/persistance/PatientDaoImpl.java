package com.patient.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PatientDaoImpl implements PatientDao{
	@Autowired
	private SessionFactory factory;
	private Session  getSession() {
		return factory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Patient> getAllpatients() {
		
		return getSession().createQuery("from Patient").list();
	}

	@Override
	public Patient getPatientById(int patientId) {
		return  (Patient) getSession().get(Patient.class,patientId );
		
	}

	@Override
	public Patient addPatient(Patient patient) {
		getSession().save(patient);
		
		return patient ;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		getSession().update(patient);
		return patient;
		
	}

	@Override
	public Patient removePatient(int patientId) {
		Patient  patientToBeDeleted=getPatientById(patientId);
		getSession().delete(patientToBeDeleted );
	return patientToBeDeleted;
		
	}

}
