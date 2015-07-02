package com.easyrent.webapp.controller;

import com.easyrent.webapp.persistance.entity.User;
import com.easyrent.webapp.service.UserService;
import com.easyrent.webapp.util.FileUploadHelper;
import com.easyrent.webapp.util.Validators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by sabir.salman on 4/1/15.
 */
@Controller
public class SignUpController {

    private static final Logger log = LoggerFactory.getLogger(SignUpController.class);
    private FileUploadHelper fileUploadHelper = new FileUploadHelper();

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String getSignUpPage(ModelMap model) {
        log.debug("at signup page");

        model.addAttribute("userSignUp", new User());

        return "registration";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public String userRegistration(@Valid @ModelAttribute(value = "userSignUp") User userSignUp,
                                   BindingResult bindingResult,
                                   @RequestParam(value = "picture") MultipartFile image,
                                   RedirectAttributes redirectAttributes) throws IOException {
        log.debug("credentials sent from registration page");

        if (bindingResult.hasErrors()) {

            return "registration";
        }

        if (Validators.isValidInfo(userService, userSignUp) && fileUploadHelper.isImageUploadSuccessful(image)) {
            userSignUp.setImage(image.getBytes());
            userService.insertUser(userSignUp);

            redirectAttributes.addFlashAttribute("success",
                    messageSource.getMessage("success.user.signup", null, "",
                            Locale.ENGLISH));
        } else {
            redirectAttributes.addFlashAttribute("failure",
                    messageSource.getMessage("error.user.signup", null, "",
                            Locale.ENGLISH));
        }

        return "redirect:/signup";
    }
}
