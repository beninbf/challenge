package com.zendesk.challenge.controller;

import com.zendesk.challenge.builder.UserBuilder;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.UserModel;
import com.zendesk.challenge.service.UserService;
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

@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET, params = {"field", "value"})
    public String organization(@RequestParam("field") String field, @RequestParam("value") String value, Map<String, Object> model) {
        value = value.isEmpty() ? null : value;
        List<User> users = userService.getUsers(field, value);

        List<UserModel> userModels = new ArrayList<>();
        for (User user : users) {
            UserModel userModel = new UserBuilder().user(user).buildModel();
            userModels.add(userModel);
        }
        logger.info(String.format("number of users retrieved %s", users.size()));
        model.put("message", "please work");
        model.put("field", field);
        model.put("value", value);
        model.put("users", userModels);
        return "user";
    }
}