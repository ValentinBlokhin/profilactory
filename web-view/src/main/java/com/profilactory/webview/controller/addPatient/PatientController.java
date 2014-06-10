package com.profilactory.webview.controller.addPatient;

import com.profilactory.model.entity.*;
import com.profilactory.model.repository.IPatient;
import com.profilactory.service.EntityService;
import com.profilactory.service.IReportPatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by ValentinBlokhin on 5/27/2014.
 */
@Controller
public class PatientController {
    @Autowired
    @Qualifier("PatientService")
    private EntityService<Patient> patientEntityService;

    @Autowired
    private IReportPatientService patientRepository;

    private static final Logger logger = Logger.getLogger("Global");

    @RequestMapping(value = "/manage/patient", method = RequestMethod.GET)
    public ModelAndView loadTable() {
        ModelAndView modelAndView = new ModelAndView("/ManageAdd/patient/patient", "CommandPatient", new Patient());
        modelAndView.addObject("patientsList", patientEntityService.getAll(0, 1000));
        modelAndView.addObject("patient", new Patient());

        // logger.debug("patient list size is: " + patientEntityService.getAll(0, 1000).size());

        return modelAndView;
    }

    @RequestMapping(value = "/manage/patient/add", method = RequestMethod.GET)
    public ModelAndView addPatient() {
        //logger.info("in addRoom method");
        return new ModelAndView("ManageAdd/patient/addPatient", "addPatient", new Patient());
    }

    @RequestMapping(value = "/manage/patient/add", method = RequestMethod.POST)
    public String savePatient(@Valid @ModelAttribute("addPatient") Patient patient, BindingResult result, Model model) {


        if (result.hasErrors()) {
            //  logger.info("in save patient method. Has validation error");
            return "ManageAdd/patient/addPatient";
        } else {
            patientEntityService.save(patient);
            //  logger.info("IN: savePatient. Add patient success");
            model.addAttribute("patientValues", patient);
            return "ManageAdd/patient/done";
        }
    }

    @RequestMapping(value = "/manage/patient/edit/{id}", method = RequestMethod.GET)
    public String showEditRoom(Model model, @PathVariable int id) {

        model.addAttribute("editPatients", patientEntityService.get(id));

        return "/ManageAdd/patient/edit";

    }

    @RequestMapping(value = "manage/patient/info/{id}", method = RequestMethod.GET)
    public String getPatientInfo(@PathVariable Integer id, Model model) {

        Permit permitForDate = null;
        Diagnosis diagnosis = null;
        List<Procedure> procedure = null;
        List passedProcedure = null;
        Room rooms = null;
        List drugList = null;

        try {
            permitForDate = patientRepository.findPermitByPatientId(id).get(0);
            diagnosis = patientRepository.findDiagnosisForPatient(id).get(0);
            procedure = patientRepository.findProcedureByPatientId(id);
            passedProcedure = patientRepository.findPassedProceduresByPatientId(id);
            rooms = patientRepository.findRoomByPatientId(id).get(0);
            drugList = patientRepository.findDrugByPatientId(id);
        } catch (IndexOutOfBoundsException ex) {
            logger.info("IN getPatientInfo : no data found exception");
        }

        model.addAttribute("permitForDate", permitForDate);
        model.addAttribute("diagnosis", diagnosis);
        model.addAttribute("procedureList", procedure);
        model.addAttribute("passedProcedureList", passedProcedure);
        model.addAttribute("rooms", rooms);
        model.addAttribute("drugList", drugList);
        return "ManageAdd/patient/info";
    }

    @RequestMapping(value = "/manage/patient/edit/{id}", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute("editPatients") Patient patient, @PathVariable Integer id, Model model) {

        patient.setPatientId(id);

        patientEntityService.update(patient);
        model.addAttribute("patientsList", patientEntityService.getAll(0, 1000));

        return "ManageAdd/patient/patient";
    }

    @RequestMapping(value = "manage/patient/delete/{id}", method = RequestMethod.GET)
    public String deleteRoom(@PathVariable Integer id, Model model) {

        //logger.debug("IN: deletePatient by id " + id);

        Patient patient = patientEntityService.get(id);

        patientEntityService.delete(patient);
        model.addAttribute("patientsList", patientEntityService.getAll(0, 1000));

        return "redirect:/manage/patient";

    }

}
