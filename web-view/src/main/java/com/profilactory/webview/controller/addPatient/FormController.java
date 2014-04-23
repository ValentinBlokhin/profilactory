package com.profilactory.webview.controller.addPatient;

import com.profilactory.model.entity.Room;
import com.profilactory.service.EntityService;
import com.profilactory.service.transactional.TransactionalRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ValentinBlokhin on 4/23/2014.
 */
@Controller
public class FormController {

    @Autowired
    @Qualifier("RoomService")
    EntityService<Room> roomService;


    @RequestMapping(value = "/addPatient", method = RequestMethod.GET)
    public ModelAndView loadForm() {

        return new ModelAndView("patient", "command", new Room());
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String print(@ModelAttribute Room room) {
        roomService.saveOrUpdate(room);
        return "patient";
    }
}
