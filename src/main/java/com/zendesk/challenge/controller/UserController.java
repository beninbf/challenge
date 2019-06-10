package com.zendesk.challenge.controller;

import com.zendesk.challenge.builder.OrganizationBuilder;
import com.zendesk.challenge.builder.UserBuilder;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.OrganizationModel;
import com.zendesk.challenge.model.UserModel;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.service.UserService;
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
 * <code>UserController</code> for mapping requests to the user.jsp page
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
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @Inject
    private TimeFormatter timeFormatter;

    @RequestMapping(value = "/user", method = RequestMethod.GET, params = {"field", "value"})
    public String user(@RequestParam("field") String field, @RequestParam("value") String value, Map<String, Object> model) {
        logger.info(String.format("Querying for users by field=%s and value=%s", field, value));

        List<User> users = userService.findUsers(field, value);
        List<UserModel> userModels = new ArrayList<>();
        List<OrganizationModel> organizationModels = new ArrayList<>();
        Set<Long> organizationIds = new HashSet<>();

        for (User user : users) {
            UserModel userModel = new UserBuilder().user(user).organization(user.getOrganization()).timeFormatter(timeFormatter).buildModel();
            userModels.add(userModel);
            if (user.getOrganization() != null && !organizationIds.contains(user.getOrganization().getId())) {
                OrganizationModel organizationModel = new OrganizationBuilder()
                    .organization(user.getOrganization())
                    .timeFormatter(timeFormatter)
                    .buildModel();
                organizationModels.add(organizationModel);
                organizationIds.add(user.getOrganization().getId());
            }
        }

        logger.info(String.format("number of users retrieved %s", userModels.size()));
        logger.info(String.format("number of organizations retrieved %s", organizationModels.size()));
        model.put("field", field);
        model.put("value", value);
        model.put("users", userModels);
        model.put("usersCount", userModels.size());
        model.put("organizations", organizationModels);
        model.put("organizationsCount", organizationModels.size());
        return "user";
    }
}
