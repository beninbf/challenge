package com.zendesk.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TicketOptionsController {
    @RequestMapping(value="/ticket-options", method = RequestMethod.GET)
    public String ticketOptions() {
        return "ticket-options";
    }
}