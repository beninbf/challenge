package com.zendesk.challenge.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendesk.challenge.builder.OrganizationBuilder;
import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.model.OrganizationModel;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
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
 * <code>OrganizationDataLoader</code> runs at startup to populate our in memory database.
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
@Order(1)
public class OrganizationDataLoader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(OrganizationDataLoader.class);

    private final static String ORGANIZATION_SEED_PATH = "json_data/organizations.json";

    @Inject
    private OrganizationService organizationService;

    @Inject
    private TimeFormatter timeFormatter;

    @Override
    public void run(String[] args) {
        logger.info("saving organizations to storage");

        // read user.json seed file
        File file = new File(
            getClass().getClassLoader().getResource(ORGANIZATION_SEED_PATH).getFile()
        );

        // deserialze our json objects and save them to the database.
        try {
            String contents = getContents(file);
            List<OrganizationModel> organizationModels = getUserObjectFromJson(contents);
            for (OrganizationModel organizationModel: organizationModels) {
                Organization organization = new OrganizationBuilder()
                    .model(organizationModel)
                    .timeFormatter(timeFormatter)
                    .build();
                organizationService.save(organization);
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * Method to deserialize JSON strings.
     * @return List of UserModels
     */
    public List<OrganizationModel> getUserObjectFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(json, new TypeReference<List<OrganizationModel>>() { });
        } catch (Exception ex) {
            logger.info(ex.getMessage(), ex);
        }
        return null;
    }

    /**
     * GetContents.
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
