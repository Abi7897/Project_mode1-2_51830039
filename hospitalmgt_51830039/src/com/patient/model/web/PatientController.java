package com.patient.model.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.patient.model.persistance.Patient;
import com.patient.model.service.PatientService;



@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	 @RequestMapping(value="allpatients", method=RequestMethod.GET)
	public String getpatients(ModelMap map) {
		map.addAttribute("patients", patientService.getAllpatients());
		return "all_patients";
	}

	@RequestMapping(value = "addpatient", method = RequestMethod.GET)
	public String addPatientGet(ModelMap map) {
		map.addAttribute("patient", new Patient());
		return "addpatient";
	}

	@RequestMapping(value = "addpatient", method = RequestMethod.POST)
	public String addPatientUpdatePost(@Valid Patient patient, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addpatient";
		} else {
			if (patient.getId() == 0)
				patientService.addPatient(patient);

			else

				patientService.updatePatient(patient);

			return "redirect:allpatients";
			
		}
	}

	
	@RequestMapping(value = "delete", method = RequestMethod.GET)

	public String deletePatient(HttpServletRequest req) {
		int patientId = Integer.parseInt(req.getParameter("id"));
		patientService.removePatient(patientId);
		return "redirect:allpatients";
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updatePatientGet(HttpServletRequest req, ModelMap map) {
		int patientId = Integer.parseInt(req.getParameter("id"));
		Patient patientToBeUpdated = patientService.getPatientById(patientId);
		map.addAttribute("patient", patientToBeUpdated);
		return "addpatient";// PRG design pattern
	}
	

}
