package com.easyrent.webapp.controller;

import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.User;
import com.easyrent.webapp.service.CommercialRentalService;
import com.easyrent.webapp.service.RentalService;
import com.easyrent.webapp.util.FileUploadHelper;
import com.easyrent.webapp.util.Validators;
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
@RequestMapping(value = {"/commercial"})
public class CommercialRentalController {

    private static final Logger log = LoggerFactory.getLogger(CommercialRentalController.class);
    private FileUploadHelper fileUploadHelper = new FileUploadHelper();

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @Autowired
    private CommercialRentalService commercialRentalService;

    @Autowired
    private RentalService rentalService;

    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("categories", commercialRentalService.getCommercialRentalCategories());
        model.addAttribute("areas", rentalService.getAreas());
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String getCommercialRentalForm(ModelMap model) {
        log.debug("showing commercial rental post form");

        model.addAttribute("commercialRental", new CommercialRental());

        return "commercialRentalPostForm";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String postCommercialRental(@Valid @ModelAttribute(value = "commercialRental") CommercialRental commercialRental,
                                       BindingResult bindingResult,
                                       @RequestParam(value = "pictureOne") MultipartFile pictureOne,
                                       @RequestParam(value = "pictureTwo", required = false) MultipartFile pictureTwo,
                                       @RequestParam(value = "pictureThree", required = false) MultipartFile pictureThree,
                                       RedirectAttributes redirectAttributes) throws IOException {
        log.debug("posting a commercial rental now");

        if (bindingResult.hasErrors()) {
            return "commercialRentalPostForm";
        }

        if (!fileUploadHelper.isImageUploadSuccessful(pictureOne)) {
            redirectAttributes.addFlashAttribute("failure", messageSource.getMessage("failure.rental.post", null, "",
                    Locale.ENGLISH));

            return "redirect:/commercial/add";
        }

        commercialRental.setImageOne(pictureOne.getBytes());
        fileUploadHelper.saveOptionalImages(pictureTwo, pictureThree, commercialRental);

        commercialRental.setUser((User) session.getAttribute("user"));
        int rentalId = commercialRentalService.insertCommercialRental(commercialRental);

        redirectAttributes.addFlashAttribute("success", messageSource.getMessage("success.rental.post", null, "",
                Locale.ENGLISH));

        return "redirect:/rental/view/" + rentalId;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String getCommercialRentalEditForm(@PathVariable(value = "id") Integer rentalId,
                                              ModelMap model) {
        log.debug("editing a commercial rental now");

        if (!Validators.isValidRental(rentalService, rentalId)) {
            return "invalidRequest";
        }

        Rental rental = rentalService.getSpecificRental(rentalId);
        model.addAttribute("rental", rental);

        return "commercialRentalEditForm";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String editCommercialRental(@Valid @ModelAttribute(value = "rental") CommercialRental rental,
                                       BindingResult bindingResult,
                                       @RequestParam(value = "pictureOne", required = false) MultipartFile pictureOne,
                                       @RequestParam(value = "pictureTwo", required = false) MultipartFile pictureTwo,
                                       @RequestParam(value = "pictureThree", required = false) MultipartFile pictureThree,
                                       RedirectAttributes redirectAttributes) throws IOException {
        log.debug("editing a rental now");

        if (bindingResult.hasErrors()) {
            return "commercialRentalEditForm";
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
        commercialRentalService.editRental(rental);

        redirectAttributes.addFlashAttribute("success", messageSource.getMessage("success.rental.edit", null, "",
                Locale.ENGLISH));

        return "redirect:/rental/view/" + rental.getId();
    }
}
