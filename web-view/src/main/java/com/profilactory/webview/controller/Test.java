package com.profilactory.webview.controller;

import com.profilactory.model.entity.Post;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/8/2014.
 */
@Controller
public class Test {

    @Autowired
    @Qualifier("PostService")
    EntityService<Post> postService;

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String printWelcome(ModelMap map) {
//        map.addAttribute("message", postService.getAll(0, 10));
//        return "hello";
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView print() {
        ModelAndView andView = new ModelAndView("hello");
        andView.addObject("list", postService.getAll(0, 10));
        return andView;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mainPage(ModelMap map) {
        return "index";
    }
}
