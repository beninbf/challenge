package com.zendesk.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * <code>TicketOptionsController</code> for mapping requests to the ticket-options.jsp page
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
@Controller
public class TicketOptionsController {
    @RequestMapping(value="/ticket-options", method = RequestMethod.GET)
    public String ticketOptions() {
        return "ticket-options";
    }
}