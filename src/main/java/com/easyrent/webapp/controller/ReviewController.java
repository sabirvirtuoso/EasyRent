package com.easyrent.webapp.controller;

import com.easyrent.webapp.persistance.entity.Review;
import com.easyrent.webapp.persistance.entity.User;
import com.easyrent.webapp.service.RentalService;
import com.easyrent.webapp.service.ReviewService;
import com.easyrent.webapp.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by sabir.salman on 4/27/2015.
 */
@Controller
public class ReviewController {

    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private RentalService rentalService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"/review/{rentalId}"}, method = RequestMethod.POST)
    public String addReview(@Valid @ModelAttribute(value = "review") Review review, BindingResult bindingResult,
                            @PathVariable Integer rentalId, RedirectAttributes redirectAttributes) {
        log.debug("posting a review now");

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("failure",
                    messageSource.getMessage("failure.post.review", null, "",
                            Locale.ENGLISH));

            return "redirect:/rental/view/" + rentalId;
        }

        review.setRental(rentalService.getSpecificRental(rentalId));
        review.setUser((User) session.getAttribute("user"));
        reviewService.insertReview(review);

        redirectAttributes.addFlashAttribute("success",
                messageSource.getMessage("success.post.review", null, "",
                        Locale.ENGLISH));

        return "redirect:/rental/view/" + rentalId;
    }
}
