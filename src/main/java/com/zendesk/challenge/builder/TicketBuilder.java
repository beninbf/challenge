package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.TicketModel;
import com.zendesk.challenge.service.TimeFormatter;

/**
 *
 * <code>TicketBuilder</code> Builder class for building Ticket JPA objects and Ticket Models
 *
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class TicketBuilder {

    private TicketModel model;

    private Ticket ticket;

    private Organization organization;

    private User assignee;

    private User submitter;

    private TimeFormatter timeFormatter;

    public TicketBuilder model(TicketModel model) {
        this.model = model;
        return this;
    }

    public TicketBuilder ticket(Ticket ticket) {
        this.ticket = ticket;
        return this;
    }

    public TicketBuilder assignee(User assignee) {
        this.assignee = assignee;
        return this;
    }

    public TicketBuilder submitter(User submitter) {
        this.submitter = submitter;
        return this;
    }

    public TicketBuilder organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public TicketBuilder timeFormatter(TimeFormatter timeFormatter) {
        this.timeFormatter = timeFormatter;
        return this;
    }

    public Ticket build() {
        if (model != null && timeFormatter != null) {
            Ticket ticket = new Ticket();
            ticket.setId(model.getId());
            ticket.setUrl(model.getUrl());
            ticket.setExternalId(model.getExternalId());
            if (model.getCreatedAt() != null) {
                ticket.setCreatedDate(timeFormatter.getDateFromString(model.getCreatedAt()));
            }
            ticket.setType(model.getType());
            ticket.setSubject(model.getSubject());
            ticket.setDescription(model.getDescription());
            ticket.setPriority(model.getPriority());
            ticket.setStatus(model.getStatus());
            ticket.setSubmitter(submitter);
            ticket.setAssignee(assignee);
            if (model.getDueAt() != null) {
                ticket.setDueDate(timeFormatter.getDateFromString(model.getDueAt()));
            }
            ticket.setVia(model.getVia());
            ticket.setOrganization(organization);
            ticket.setHasIncidents(model.getHasIncidents());
            ticket.setTags(model.getTags());
            return ticket;
        } else {
            throw new IllegalArgumentException("TicketModel and TimeFormatter must be set to create a ticket db object");
        }
    }

    public TicketModel buildModel() {
        if (ticket != null) {
            TicketModel ticketModel = new TicketModel();
            ticketModel.setId(ticket.getId());
            ticketModel.setUrl(ticket.getUrl());
            ticketModel.setExternalId(ticket.getExternalId());
            if (ticket.getCreatedDate() != null) {
                ticketModel.setCreatedAt(timeFormatter.getStringFromTimeStamp(ticket.getCreatedDate()));
            }
            ticketModel.setType(ticket.getType());
            ticketModel.setSubject(ticket.getSubject());
            ticketModel.setDescription(ticket.getDescription());
            ticketModel.setPriority(ticket.getPriority());
            ticketModel.setStatus(ticket.getStatus());
            if (submitter != null) {
                ticketModel.setSubmitterId(submitter.getId());
            }
            if (assignee != null) {
                ticketModel.setAssigneeId(assignee.getId());
            }if (organization != null) {
                ticketModel.setOrganizationId(organization.getId());
            }
            if (ticket.getDueDate() != null) {
                ticketModel.setDueAt(timeFormatter.getStringFromTimeStamp(ticket.getDueDate()));
            }
            ticketModel.setVia(ticket.getVia());
            ticketModel.setHasIncidents(ticket.hasIncidents());
            ticketModel.setTags(ticket.getTags());
            return ticketModel;
        } else {
            throw new IllegalArgumentException("Ticket and TimeFormatter must be set to create a tick model object");
        }
    }
}
