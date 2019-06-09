package com.zendesk.challenge.controller;

import com.zendesk.challenge.data.domain.jpa.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * <code>UserOptionsController</code> for mapping requests to the user-options.jsp page
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
public class UserOptionsController {
    @RequestMapping(value="/user-options", method = RequestMethod.GET)
    public String userOptions(Map<String, Object> model) {
        User user = new User();
        Field[] fields = user.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for(Field field: fields) {
            if (field.getName().equals("serialVersionUID")) {
                continue;
            }
            fieldNames.add(field.getName());
        }
        model.put("fieldNames", fieldNames);
        return "user-options";
    }
}
