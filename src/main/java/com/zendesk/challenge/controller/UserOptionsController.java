package com.zendesk.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserOptionsController {
    @RequestMapping(value="/user-options", method = RequestMethod.GET)
    public String userOptions() {
        return "user-options";
    }
}
