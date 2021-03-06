package com.zendesk.challenge.controller;

import com.zendesk.challenge.builder.OrganizationBuilder;
import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.model.OrganizationModel;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * <code>OrganizationController</code> for mapping requests to the organization.jsp page
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
@Controller
public class OrganizationController {

    private static Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @Inject
    private OrganizationService organizationService;

    @Inject
    private TimeFormatter timeFormatter;

    @RequestMapping(value="/organization", method = RequestMethod.GET, params = {"field", "value"})
    public String organization(@RequestParam("field") String field, @RequestParam("value") String value, Map<String, Object> model) {
        logger.info(String.format("Querying for users by field=%s and value=%s", field, value));
        List<Organization> organizations = organizationService.findOrganizationsByField(field, value);

        List<OrganizationModel> organizationModels = new ArrayList<>();
        for (Organization organization: organizations) {
            OrganizationModel organizationModel = new OrganizationBuilder()
                .organization(organization)
                .timeFormatter(timeFormatter)
                .buildModel();
            organizationModels.add(organizationModel);
        }
        logger.info(String.format("number of organizations retrieved %s", organizations.size()));
        model.put("field", field);
        model.put("value", value);
        model.put("organizations", organizationModels);
        model.put("organizationsCount", organizationModels.size());
        return "organization";
    }
}
