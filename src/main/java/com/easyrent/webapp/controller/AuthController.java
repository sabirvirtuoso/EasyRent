package com.easyrent.webapp.controller;

import com.easyrent.webapp.persistance.entity.User;
import com.easyrent.webapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by sabir.salman on 5/12/15.
 */
@Controller
@SessionAttributes(value = "user")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLoginPage(ModelMap model) {
        log.debug("at login page");

        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password,
                        ModelMap model) {
        log.debug("credentials sent from login page");

        User loggedInUser = userService.loginUser(email, password);

        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);

            return "redirect:/profile/" + loggedInUser.getId();
        }

        String message = messageSource.getMessage("error.incorrect.credential", null, "", Locale.ENGLISH);
        model.addAttribute("error", message);

        return "login";
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(ModelMap model) {
        log.debug("logging out");

        session.invalidate();

        return "redirect:/login";
    }
}
