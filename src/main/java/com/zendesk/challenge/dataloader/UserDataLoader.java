package com.zendesk.challenge.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendesk.challenge.builder.UserBuilder;
import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.model.UserModel;
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
import java.net.URL;
import java.util.List;
import java.util.Optional;

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
@Order(2)
public class UserDataLoader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(UserDataLoader.class);

    private final static String USER_SEED_PATH = "json_data/users.json";

    @Inject
    private UserRepository userRepository;

    @Inject
    private OrganizationRepository organizationRepository;

    @Override
    public void run(String[] args) {
        logger.info("saving users to storage");

        // read user.json seed file
        File file = new File(
            getClass().getClassLoader().getResource(USER_SEED_PATH).getFile()
        );

        // deserialze our json objects and save them to the database.
        try {
            String contents = getContents(file);
            List<UserModel> userModels = getUserObjectFromJson(contents);
            for (UserModel userModel: userModels) {
                Organization organization = null;
                if (userModel.getOrganizationId() != null) {
                    Optional<Organization> organizationOptional = organizationRepository.findById(userModel.getOrganizationId());
                    organization = organizationOptional.isPresent() ? organizationOptional.get() : null;
                }
                User user = new UserBuilder().model(userModel).organization(organization).build();
                userRepository.save(user);
            }
        } catch (IOException ex) {
            logger.info(ex.getMessage(), ex);
        }
    }

    /**
     * Method to deserialize JSON strings.
     * @return List of UserModels
     */
    public List<UserModel> getUserObjectFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(json, new TypeReference<List<UserModel>>() { });
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return null;
    }

    /**
     * Returns a file.
     * @param fileName String
     * @return File
     */
    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
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
