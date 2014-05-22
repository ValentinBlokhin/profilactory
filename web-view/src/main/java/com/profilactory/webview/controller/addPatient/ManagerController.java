package com.profilactory.webview.controller.addPatient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Permit;
import com.profilactory.model.entity.Personal;
import com.profilactory.model.entity.Room;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Qualifier("PersonalService")
    EntityService<Personal> personalService;

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public ModelAndView loadForm() {
        ModelAndView modelAndView = new ModelAndView("manage", "commandRoom", new Room());
        modelAndView.addObject("Room", new Room());
        modelAndView.addObject("roomList", roomService.getAll(0, 1000));
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
            roomService.save(room);
            logger.info("IN: saveRoom. Add room success");
            model.addAttribute("roomValues", room);
            return "ManageAdd/room/done";
        }
    }

    @RequestMapping(value = "/manage/room/edit/{id}", method = RequestMethod.GET)
    public String showEditRoom(Model model, @PathVariable int id) {

        model.addAttribute("editRooms", roomService.get(id));

        return "/ManageAdd/room/edit";

    }

    @RequestMapping(value = "/manage/room/edit/{id}", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute("editRooms") Room room, @PathVariable Integer id, Model model) {

        room.setRoomId(id);

        roomService.update(room);
        model.addAttribute("roomList", roomService.getAll(0, 1000));

        return "manage";
    }


    @RequestMapping(value = "/manage/personal", method = RequestMethod.GET)
    public ModelAndView loadPersonalForm() {
        ModelAndView modelAndView = new ModelAndView("ManageAdd/personal/main", "commandPersonal", new Personal());
        modelAndView.addObject("Personal", new Personal());
        modelAndView.addObject("PersonalList", personalService.getAll(0, 10));
        logger.info("PersonalService getAll size: " + permitService.getAll(0, 10).size());
        return modelAndView;
    }

    @RequestMapping(value = "/manage/room/addRoom/check", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxTest(WebRequest request) throws Exception {

        String available;
        String roomNumberInput = request.getParameter("roomNumber");
        Integer number = Integer.parseInt(roomNumberInput);
        List<Room> rooms = roomService.findByCriteria(number);
        if (rooms.size() > 0) {
            available = "false";
        } else {
            available = "true";
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(available);
    }
}
