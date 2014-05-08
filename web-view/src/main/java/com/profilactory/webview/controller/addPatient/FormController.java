package com.profilactory.webview.controller.addPatient;

import com.profilactory.model.entity.Permit;
import com.profilactory.model.entity.Room;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;

import javax.persistence.Entity;

/**
 * Created by ValentinBlokhin on 4/23/2014.
 */
@Controller
public class FormController {
    private static final Logger logger = Logger.getLogger(FormController.class);

    @Autowired
    @Qualifier("RoomService")
    EntityService<Room> roomService;

    @Autowired
    @Qualifier("PermitService")
    EntityService<Permit> permitService;

    @RequestMapping(value = "/addPatient", method = RequestMethod.GET)
    public String loadForm(ModelMap map) {
//        map.addAttribute("room", new Room());
        map.addAttribute("roomList", roomService.getAll(0, 10));
        logger.info("roomService getAll size: " + roomService.getAll(0, 10).size());
        map.addAttribute("permit", permitService.getAll(0, 10));
        return "patient";
    }

    @RequestMapping(value = "#permit", method = RequestMethod.GET)
    public String loadFormForPermit(@ModelAttribute Permit permit) {

        return "patient";
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String print(@ModelAttribute Room room) {
        roomService.saveOrUpdate(room);
        return "patient";
    }
}
