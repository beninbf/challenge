package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.model.TicketModel;

import java.sql.Timestamp;

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

    public TicketBuilder model(TicketModel model) {
        this.model = model;
        return this;
    }

    public TicketBuilder ticket(Ticket ticket) {
        this.ticket = ticket;
        return this;
    }

    public Ticket build() {
        if (model != null) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(model.getId());
            ticket.setUrl(model.getUrl());
            ticket.setExternalId(model.getExternalId());
            if (model.getCreatedAt() != null) {
                ticket.setCreatedDate(new Timestamp(model.getCreatedAt().getTime()));
            }
            ticket.setType(model.getType());
            ticket.setSubject(model.getSubject());
            ticket.setDescription(model.getDescription());
            ticket.setPriority(model.getPriority());
            ticket.setStatus(model.getStatus());
            ticket.setSubmitterId(model.getSubmitterId());
            ticket.setAssigneeId(model.getAssigneeId());
            ticket.setOrganizationId(model.getOrganizationId());
            if (model.getDueAt() != null) {
                ticket.setDueDate(new Timestamp(model.getDueAt().getTime()));
            }
            ticket.setVia(model.getVia());
            ticket.setOrganizationId(model.getOrganizationId());
            ticket.setHasIncidents(model.getHasIncidents());
            ticket.setTags(model.getTags());
            return ticket;
        } else {
            throw new IllegalArgumentException("UserModel must be set to create a user db object");
        }
    }

    public TicketModel buildModel() {
        if (ticket != null) {
            TicketModel ticketModel = new TicketModel();
            ticketModel.setId(ticket.getTicketId());
            ticketModel.setUrl(ticket.getUrl());
            ticketModel.setExternalId(ticket.getExternalId());
            if (ticket.getCreatedDate() != null) {
                ticketModel.setCreatedAt(new Timestamp(ticket.getCreatedDate().getTime()));
            }
            ticketModel.setType(ticket.getType());
            ticketModel.setSubject(ticket.getSubject());
            ticketModel.setDescription(ticket.getDescription());
            ticketModel.setPriority(ticket.getPriority());
            ticketModel.setStatus(ticket.getStatus());
            ticketModel.setSubmitterId(ticket.getSubmitterId());
            ticketModel.setAssigneeId(ticket.getAssigneeId());
            ticketModel.setOrganizationId(ticket.getOrganizationId());
            if (ticket.getDueDate() != null) {
                ticketModel.setDueAt(new Timestamp(ticket.getDueDate().getTime()));
            }
            ticketModel.setVia(ticket.getVia());
            ticketModel.setOrganizationId(ticket.getOrganizationId());
            ticketModel.setHasIncidents(ticket.hasIncidents());
            ticketModel.setTags(ticket.getTags());
            return ticketModel;
        } else {
            throw new IllegalArgumentException("Ticket must be set to create a tick model object");
        }
    }
}
