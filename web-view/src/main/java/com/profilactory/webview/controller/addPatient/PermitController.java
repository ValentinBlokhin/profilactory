package com.profilactory.webview.controller.addPatient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profilactory.model.entity.Patient;
import com.profilactory.model.entity.Permit;
import com.profilactory.model.entity.Room;
import com.profilactory.service.EntityService;
import com.profilactory.service.ReportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ValentinBlokhin on 5/28/2014.
 */
@Controller
public class PermitController {

    @Autowired
    @Qualifier("PermitService")
    private EntityService<Permit> permitEntityService;

    @Autowired
    @Qualifier("RoomService")
    private EntityService<Room> roomEntityService;

    @Autowired
    @Qualifier("PatientService")
    private EntityService<Patient> patientEntityService;

    @Autowired
    private ReportService reportService;


    private final Logger logger = Logger.getLogger("Global");

    @RequestMapping(value = "/manage/permit", method = RequestMethod.GET)
    public ModelAndView loadTable() {
        ModelAndView modelAndView = new ModelAndView("/ManageAdd/permit/permit", "CommandPermit", new Permit());
        modelAndView.addObject("permitList", permitEntityService.getAll(0, 1000));
        modelAndView.addObject("permit", new Permit());

        logger.debug("permit list size is: " + permitEntityService.getAll(0, 1000).size());

        return modelAndView;
    }

    @RequestMapping(value = "/manage/permit/add", method = RequestMethod.GET)
    public ModelAndView addPermit() {
        logger.info("in addPermit method");
        ModelAndView modelAndView = new ModelAndView("ManageAdd/permit/addPermit", "addPermit", new Permit());
        modelAndView.addObject("roomList", roomEntityService.getAll(0, 1000));
        modelAndView.addObject("patientList", patientEntityService.getAll(0, 1000));
        return modelAndView;
    }

    @RequestMapping(value = "/manage/permit/add", method = RequestMethod.POST)
    public String savePermit(@Valid @ModelAttribute("addPermit") Permit permit, BindingResult result, Model model) {


        if (result.hasErrors()) {
            logger.info("in save permit method. Has validation error");
            return "ManageAdd/permit/permit";
        } else {
            permitEntityService.save(permit);
            logger.info("IN: savePermit. Add permitt success");
            model.addAttribute("permitValues", permit);
            return "ManageAdd/permit/done";
        }
    }

    @RequestMapping(value = "/manage/permit/edit/{id}", method = RequestMethod.GET)
    public String showEditPermit(Model model, @PathVariable int id) {

        model.addAttribute("editPermits", permitEntityService.get(id));
        model.addAttribute("roomList", roomEntityService.getAll(0, 1000));
        model.addAttribute("patientList", patientEntityService.getAll(0, 1000));
        return "/ManageAdd/permit/edit";

    }

    @RequestMapping(value = "/manage/permit/edit/{id}", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute("editPermits") Permit permit, @PathVariable Integer id, Model model) {

        permit.setPermitId(id);

        permitEntityService.update(permit);
        model.addAttribute("permitList", permitEntityService.getAll(0, 1000));

        return "redirect:/manage/permit";
    }

    @RequestMapping(value = "manage/permit/delete/{id}", method = RequestMethod.GET)
    public String deletePermit(@PathVariable Integer id, Model model) {

        logger.debug("IN: deletePermit by id " + id);

        Permit permit = permitEntityService.get(id);

        permitEntityService.delete(permit);
        model.addAttribute("patientsList", patientEntityService.getAll(0, 1000));

        return "redirect:/manage/permit";

    }

    @RequestMapping(value = "/manage/permit/check-free-seats/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String checkFreeSeats(@PathVariable Integer id, Model model) throws JsonProcessingException {
        boolean available = reportService.checkFreeSeats(id);
        String response;
        ObjectMapper mapper = new ObjectMapper();

        if (available) {
            response = "true";
        } else {
            response = "false";
        }
        return mapper.writeValueAsString(response);
    }

    @RequestMapping(value = "manage/permitstatistics", method = RequestMethod.GET)
    public String showPermitStatistics() throws ParseException {
        return "ManageAdd/statistics/permitStatistics";
    }

    @RequestMapping(value = "manage/permitstatistics", method = RequestMethod.POST)
    public String getPermitStatistics(@RequestParam("fromInput") String checkIn, @RequestParam("toInput") String checkOut, Model model) throws ParseException {

        List someList = reportService.findPermitByDate(checkIn, checkOut);
        model.addAttribute("resultList", someList);

        return "ManageAdd/statistics/byDate";
    }

    @RequestMapping(value = "/manage/permstats/data", method = RequestMethod.POST)
    @ResponseBody
    public String checkDate(WebRequest request) throws ParseException, JsonProcessingException {

        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");

        logger.info("IN checkDatePermitStatistics: checkIn is " + checkIn + " checkOut is " + checkOut);
        List someList = reportService.findPermitByDate(checkIn, checkOut);
        String checkData;

        if (someList.isEmpty()) {
            checkData = "false";
        } else {
            checkData = "true";
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(checkData);
    }

    @RequestMapping(value = "manage/permitstatistics/bydate", method = RequestMethod.GET)
    public String getByDateStats() {
        return "ManageAdd/statistics/byDate";
    }

}
