package com.zendesk.challenge.controller;

import com.zendesk.challenge.builder.OrganizationBuilder;
import com.zendesk.challenge.builder.TicketBuilder;
import com.zendesk.challenge.builder.UserBuilder;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.model.OrganizationModel;
import com.zendesk.challenge.model.TicketModel;
import com.zendesk.challenge.model.UserModel;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.TimeFormatter;
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

    @Inject
    private TicketService ticketService;

    @Inject
    private TimeFormatter timeFormatter;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET, params = {"field", "value"})
    public String ticket(@RequestParam("field") String field, @RequestParam("value") String value, Map<String, Object> model) {
        logger.info(String.format("Querying for tickets by field=%s and value=%s", field, value));

        List<Ticket> tickets = ticketService.findTickets(field, value);
        List<TicketModel> ticketModels = new ArrayList<>();
        List<OrganizationModel> organizationModels = new ArrayList<>();
        List<UserModel> assigneeModels = new ArrayList<>();
        List<UserModel> submitterModels = new ArrayList<>();

        Set<Long> assigneeIds = new HashSet<>();
        Set<Long> submitterIds = new HashSet<>();
        Set<Long> organizationIds = new HashSet<>();

        for (Ticket ticket : tickets) {
            TicketModel ticketModel = new TicketBuilder()
                .ticket(ticket)
                .organization(ticket.getOrganization())
                .assignee(ticket.getAssignee())
                .submitter(ticket.getSubmitter())
                .timeFormatter(timeFormatter)
                .buildModel();
            ticketModels.add(ticketModel);
            if (ticket.getOrganization() != null && !organizationIds.contains(ticket.getOrganization().getId())) {
                OrganizationModel organizationModel = new OrganizationBuilder()
                    .organization(ticket.getOrganization())
                    .timeFormatter(timeFormatter)
                    .buildModel();
                organizationModels.add(organizationModel);
                organizationIds.add(ticket.getOrganization().getId());
            }
            if (ticket.getAssignee() != null && !assigneeIds.contains(ticket.getAssignee().getId())) {
                UserModel assigneeModel = new UserBuilder()
                    .user(ticket.getAssignee())
                    .organization(ticket.getOrganization())
                    .timeFormatter(timeFormatter)
                    .buildModel();
                assigneeModels.add(assigneeModel);
                assigneeIds.add(ticket.getAssignee().getId());
            }
            if (ticket.getSubmitter() != null && !submitterIds.contains(ticket.getSubmitter().getId())) {
                UserModel submitterModel = new UserBuilder()
                    .user(ticket.getSubmitter())
                    .organization(ticket.getOrganization())
                    .timeFormatter(timeFormatter)
                    .buildModel();
                submitterModels.add(submitterModel);
                submitterIds.add(ticket.getSubmitter().getId());
            }
        }
        logger.info(String.format("number of tickets retrieved %s", ticketModels.size()));
        logger.info(String.format("number of organizations retrieved %s", organizationModels.size()));
        logger.info(String.format("number of assignees retrieved %s", assigneeModels.size()));
        logger.info(String.format("number of submitters retrieved %s", submitterModels.size()));
        model.put("field", field);
        model.put("value", value);
        model.put("tickets", ticketModels);
        model.put("ticketsCount", ticketModels.size());
        model.put("organizations", organizationModels);
        model.put("organizationsCount", organizationModels.size());
        model.put("assignees", assigneeModels);
        model.put("assigneesCount", assigneeModels.size());
        model.put("submitters", submitterModels);
        model.put("submittersCount", submitterModels.size());
        return "ticket";
    }
}