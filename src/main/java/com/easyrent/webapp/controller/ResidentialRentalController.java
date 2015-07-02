package com.easyrent.webapp.controller;

import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
import com.easyrent.webapp.persistance.entity.User;
import com.easyrent.webapp.service.RentalService;
import com.easyrent.webapp.service.ResidentialRentalService;
import com.easyrent.webapp.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by sabir.salman on 4/26/15.
 */
@Controller
@RequestMapping(value = {"/residential"})
public class ResidentialRentalController {

    private static final Logger log = LoggerFactory.getLogger(ResidentialRentalController.class);
    private FileUploadHelper fileUploadHelper = new FileUploadHelper();

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @Autowired
    private ResidentialRentalService residentialRentalService;

    @Autowired
    private RentalService rentalService;

    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("categories", residentialRentalService.getResidentialRentalCategories());
        model.addAttribute("areas", rentalService.getAreas());
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String getResidentialRentalForm(ModelMap model) {
        log.debug("showing residential rental post form");

        model.addAttribute("residentialRental", new ResidentialRental());

        return "residentialRentalPostForm";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String postResidentialRental(@Valid @ModelAttribute(value = "residentialRental") ResidentialRental residentialRental,
                                        BindingResult bindingResult,
                                        @RequestParam(value = "pictureOne") MultipartFile pictureOne,
                                        @RequestParam(value = "pictureTwo", required = false) MultipartFile pictureTwo,
                                        @RequestParam(value = "pictureThree", required = false) MultipartFile pictureThree,
                                        RedirectAttributes redirectAttributes, ModelMap model) throws IOException {
        log.debug("posting a residential rental now");

        if (bindingResult.hasErrors()) {

            return "residentialRentalPostForm";
        }

        if (!fileUploadHelper.isImageUploadSuccessful(pictureOne)) {
            redirectAttributes.addFlashAttribute("failure", messageSource.getMessage("failure.rental.post", null, "",
                    Locale.ENGLISH));

            return "redirect:/residential/add";
        }

        residentialRental.setImageOne(pictureOne.getBytes());
        fileUploadHelper.saveOptionalImages(pictureTwo, pictureThree, residentialRental);

        residentialRental.setUser((User) session.getAttribute("user"));
        int rentalId = residentialRentalService.insertResidentialRental(residentialRental);

        redirectAttributes.addFlashAttribute("success", messageSource.getMessage("success.rental.post", null, "",
                Locale.ENGLISH));

        return "redirect:/rental/view/" + rentalId;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String getResidentialRentalEditForm(@PathVariable(value = "id") Integer rentalId,
                                               ModelMap model) {
        log.debug("editing a residential rental now");

        if (!Validators.isValidRental(rentalService, rentalId)) {

            return "invalidRequest";
        }

        Rental rental = rentalService.getSpecificRental(rentalId);
        model.addAttribute("rental", rental);

        return "residentialRentalEditForm";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String editResidentialRental(@Valid @ModelAttribute(value = "rental") ResidentialRental rental,
                                        BindingResult bindingResult,
                                        @RequestParam(value = "pictureOne", required = false) MultipartFile pictureOne,
                                        @RequestParam(value = "pictureTwo", required = false) MultipartFile pictureTwo,
                                        @RequestParam(value = "pictureThree", required = false) MultipartFile pictureThree,
                                        RedirectAttributes redirectAttributes) throws IOException {
        log.debug("editing a rental now");

        if (bindingResult.hasErrors()) {

            return "residentialRentalEditForm";
        }

        if (!pictureOne.isEmpty()) {
            if (fileUploadHelper.isImageValidateSuccessful(pictureOne)) {
                rental.setImageOne(pictureOne.getBytes());
                redirectAttributes.addFlashAttribute("success", messageSource.getMessage("success.rental.edit", null, "",
                        Locale.ENGLISH));
            } else {
                redirectAttributes.addFlashAttribute("failure", messageSource.getMessage("failure.rental.edit", null, "",
                        Locale.ENGLISH));
            }
        }

        fileUploadHelper.saveOptionalImages(pictureTwo, pictureThree, rental);
        residentialRentalService.editRental(rental);

        redirectAttributes.addFlashAttribute("success", messageSource.getMessage("success.rental.edit", null, "",
                Locale.ENGLISH));

        return "redirect:/rental/view/" + rental.getId();
    }
}
