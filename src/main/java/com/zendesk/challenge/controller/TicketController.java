package com.zendesk.challenge.controller;

import com.zendesk.challenge.builder.TicketBuilder;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.model.TicketModel;
import com.zendesk.challenge.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * <code>TicketController</code> for mapping requests to the ticket.jsp page
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
public class TicketController {
    private static Logger logger = LoggerFactory.getLogger(TicketController.class);

    private static final Set<String> booleanTypes = new HashSet<>();
    {
        booleanTypes.add("hasIncidents");
    }

    @Inject
    private TicketService ticketService;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET, params = {"field", "value"})
    public String ticket(@RequestParam("field") String field, @RequestParam("value") String value, Map<String, Object> model) {
        logger.info(String.format("Querying for tickets by field: %s and value: %s", field, value));
        Object valueToQuery = booleanTypes.contains(field) ? getBoolean(value) : value;
        List<Ticket> tickets = ticketService.getTickets(field, valueToQuery);

        List<TicketModel> ticketModels = new ArrayList<>();
        for (Ticket ticket : tickets) {
            TicketModel ticketModel = new TicketBuilder().ticket(ticket).buildModel();
            ticketModels.add(ticketModel);
        }
        logger.info(String.format("number of tickets retrieved %s", tickets.size()));
        model.put("message", "please work");
        model.put("field", field);
        model.put("value", value);
        model.put("tickets", ticketModels);
        return "ticket";
    }

    private Boolean getBoolean(String value) {
        Boolean result = null;
        if (value.equals("true")) {
            result = Boolean.TRUE;
        } else if (value.equals("false")) {
            result = Boolean.FALSE;
        }
        return result;
    }
}