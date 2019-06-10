package com.zendesk.challenge.util;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.OrganizationModel;
import com.zendesk.challenge.model.TicketModel;
import com.zendesk.challenge.model.UserModel;
import com.zendesk.challenge.service.TimeFormatter;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * <code>GenericTestDataFactory</code> a factory producing Models and Jpa objects for testing.
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
public class GenericTestDataFactory {

    @Inject
    private TimeFormatter timeFormatter;

    public static UserModel getUserModel() {
        UserModel userModel = new UserModel();
        userModel.setId(11L);
        userModel.setUrl("Test");
        userModel.setExternalId("abc");
        userModel.setName("test name");
        userModel.setAlias("test alias");
        userModel.setCreatedAt(new Date().toString());
        userModel.setActive(true);
        userModel.setShared(true);
        userModel.setVerified(true);
        userModel.setLastLoginDate(new Date().toString());
        userModel.setEmail("test@email.com");
        userModel.setSignature("sig");
        userModel.setPhone("888-888-8888");
        userModel.setOrganizationId(3l);
        userModel.setSuspended(true);
        userModel.setTags(Arrays.asList("hello","ok","good"));
        userModel.setRole("admin");
        userModel.setLocale("locale");
        userModel.setTimezone("timezone");
        return userModel;
    }

    public static User getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setUrl("Test");
        user.setExternalId("abc");
        user.setName("test name");
        user.setAlias("test alias");
        user.setCreatedDate(new Timestamp(new Date().getTime()));
        user.setActive(true);
        user.setShared(true);
        user.setVerified(true);
        user.setLastLoginDate(new Timestamp(new Date().getTime()));
        user.setEmail("test@email.com");
        user.setSignature("sig");
        user.setPhone("888-888-8888");
        user.setOrganization(getOrganization());
        user.setSuspended(true);
        user.setTags(Arrays.asList("hello","ok","good"));
        user.setRole("admin");
        user.setLocale("locale");
        user.setTimezone("timezone");
        return user;
    }

    public static Ticket getTicket() {
        Ticket ticket = new Ticket();
        ticket.setId("aaa");
        ticket.setUrl("Test");
        ticket.setExternalId("abc");
        ticket.setCreatedDate(new Timestamp(new Date().getTime()));
        ticket.setType("test type");
        ticket.setSubject("test subject");
        ticket.setDescription("test description");
        ticket.setPriority("test priority");
        ticket.setStatus("test status");
        ticket.setSubmitter(getUser(2l));
        ticket.setAssignee(getUser(4l));
        ticket.setOrganization(getOrganization());
        ticket.setVia("via");
        ticket.setHasIncidents(true);
        ticket.setTags(Arrays.asList("blah,blah,blah"));
        ticket.setDueDate(new Timestamp(new Date().getTime()));
        return ticket;
    }

    public static TicketModel getTicketModel() {
        TicketModel ticketModel = new TicketModel();
        ticketModel.setId("aaa");
        ticketModel.setUrl("Test");
        ticketModel.setExternalId("abc");
        ticketModel.setCreatedAt(new Date().toString());
        ticketModel.setType("test type");
        ticketModel.setSubject("test subject");
        ticketModel.setDescription("test description");
        ticketModel.setPriority("test priority");
        ticketModel.setStatus("test status");
        ticketModel.setSubmitterId(2l);
        ticketModel.setAssigneeId(4l);
        ticketModel.setOrganizationId(5l);
        ticketModel.setVia("via");
        ticketModel.setHasIncidents(true);
        ticketModel.setTags(Arrays.asList("blah,blah,blah"));
        ticketModel.setDueAt(new Date().toString());
        return ticketModel;
    }

    public static OrganizationModel getOrganizationModel() {
        OrganizationModel organizationModel = new OrganizationModel();
        organizationModel.setId(5l);
        organizationModel.setUrl("Test");
        organizationModel.setName("name");
        organizationModel.setExternalId("abc");
        organizationModel.setCreatedAt(new Date().toString());
        organizationModel.setDetails("test details");
        organizationModel.setSharedTickets(true);
        organizationModel.setTags(Arrays.asList("blah,blah,blah"));
        organizationModel.setDomainNames(Arrays.asList("domain.com,blah.com,blah.com"));
        return organizationModel;
    }

    public static Organization getOrganization() {
        Organization organization = new Organization();
        organization.setId(5l);
        organization.setUrl("Test");
        organization.setName("name");
        organization.setExternalId("abc");
        organization.setCreatedDate(new Timestamp(new Date().getTime()));
        organization.setDetails("test details");
        organization.setSharedTickets(true);
        organization.setTags(Arrays.asList("blah,blah,blah"));
        organization.setDomainNames(Arrays.asList("domain.com,blah.com,blah.com"));
        return organization;
    }
}
