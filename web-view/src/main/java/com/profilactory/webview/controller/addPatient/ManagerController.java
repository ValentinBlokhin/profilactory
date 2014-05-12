package com.profilactory.webview.controller.addPatient;

import com.profilactory.model.entity.Permit;
import com.profilactory.model.entity.Room;
import com.profilactory.service.EntityService;
import com.profilactory.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by ValentinBlokhin on 4/23/2014.
 */
@Controller
public class ManagerController {
    private static final Logger logger = Logger.getLogger(ManagerController.class);

    @Autowired
    @Qualifier("RoomService")
    EntityService<Room> roomService;

    @Autowired
    @Qualifier("PermitService")
    EntityService<Permit> permitService;

    @Autowired
    @Qualifier("ValidationService")
    ValidationService validationService;

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public ModelAndView loadForm() {
        ModelAndView modelAndView = new ModelAndView("manage", "commandRoom", new Room());
        modelAndView.addObject("Room", new Room());
        modelAndView.addObject("roomList", roomService.getAll(0, 10));
        logger.info("roomService getAll size: " + roomService.getAll(0, 10).size());
        modelAndView.addObject("permit", permitService.getAll(0, 10));
        return modelAndView;
    }

    @RequestMapping(value = "/manage/room/addRoom", method = RequestMethod.GET)
    public ModelAndView addRoom() {
        logger.info("in addRoom method");
        return new ModelAndView("ManageAdd/room/addRoom", "addRoom", new Room());
    }

    @RequestMapping(value = "/manage/room/addRoom", method = RequestMethod.POST)
    public String saveRoom(@Valid @ModelAttribute("addRoom") Room room, BindingResult result, Model model) {

        if (result.hasErrors()) {
            logger.info("in save room method. Has validation error");
            return "ManageAdd/room/addRoom";
        } else {
            logger.info("IN: saveRoom. Add room success");
            roomService.saveOrUpdate(room);
            model.addAttribute("roomValues", room);
            return "ManageAdd/room/done";
        }
    }

    @RequestMapping(value = "#permit", method = RequestMethod.GET)
    public String loadFormForPermit(@ModelAttribute Permit permit) {

        return "manage";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public String print(@Valid @ModelAttribute("commandRoom") Room room, BindingResult result) {

        if (result.hasErrors()) {

            validationService.isError(true);
            return "manage";
        } else {

            roomService.saveOrUpdate(room);
            return "manage";
        }
    }
}
