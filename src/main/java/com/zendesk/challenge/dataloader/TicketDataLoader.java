package com.zendesk.challenge.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendesk.challenge.builder.TicketBuilder;
import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.TicketModel;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * <code>TicketDataLoader</code> runs at startup to populate our in memory database.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
@Component
@Order(3)
public class TicketDataLoader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(TicketDataLoader.class);

    private final static String TICKET_SEED_PATH = "json_data/tickets.json";

    @Inject
    private TicketService ticketService;

    @Inject
    private OrganizationService organizationService;

    @Inject
    private UserService userService;

    @Override
    public void run(String[] args) {
        logger.info("saving tickets to storage");

        // read user.json seed file
        File file = new File(
            getClass().getClassLoader().getResource(TICKET_SEED_PATH).getFile()
        );

        // deserialze our json objects and save them to the database.
        try {
            String contents = getContents(file);
            List<TicketModel> ticketModels = getUserObjectFromJson(contents);
            for (TicketModel ticketModel: ticketModels) {
                Organization organization = null;
                User assignee = null;
                User submitter = null;
                if (ticketModel.getOrganizationId() != null) {
                    organization = organizationService.findById(ticketModel.getOrganizationId());
                }
                if (ticketModel.getAssigneeId() != null) {
                    assignee = userService.findById(ticketModel.getAssigneeId());
                }
                if (ticketModel.getSubmitterId() != null) {
                    submitter = userService.findById(ticketModel.getSubmitterId());
                }

                Ticket ticket = new TicketBuilder()
                    .model(ticketModel)
                    .organization(organization)
                    .assignee(assignee)
                    .submitter(submitter)
                    .build();
                ticketService.save(ticket);
            }
        } catch (IOException ex) {
            logger.info(ex.getMessage(), ex);
        }
    }

    /**
     * Method to deserialize JSON strings.
     * @return List of UserModels
     */
    public List<TicketModel> getUserObjectFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(json, new TypeReference<List<TicketModel>>() { });
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return null;
    }

    /**
     * Get file Contents.
     *
     * Given a file this reads the content.
     * @param file
     * @return String
     * @throws IOException
     */
    private String getContents(File file) throws IOException {
        if (file == null) {
            return null;
        }
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }
}
