package com.profilactory.webview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ValentinBlokhin on 4/8/2014.
 */
@Controller
@RequestMapping("/welcome")
public class Test {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap map) {
        map.addAttribute("message", "Spring hello World");
        return "hello";
    }
}
