package com.zendesk.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * <code>OrganizationOptionsController</code> for mapping requests to the organization-options.jsp page
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
public class OrganizationOptionsController {
    @RequestMapping(value="/organization-options", method = RequestMethod.GET)
    public String organizationOptions() {
        return "organization-options";
    }
}