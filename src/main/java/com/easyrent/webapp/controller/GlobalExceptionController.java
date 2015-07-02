package com.easyrent.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.OptimisticLockException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by sabir.salman on 4/13/15.
 */

@ControllerAdvice
public class GlobalExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    private static final String GENERIC_ERROR_PAGE = "genericErrorPage";

    @ExceptionHandler({SQLException.class, DataAccessException.class, OptimisticLockException.class, OptimisticLockingFailureException.class})
    public ModelAndView handleGlobalException(HttpServletRequest request, Exception ex) {
        logger.error("GlobalException Occurred:: URL = " + request.getRequestURL(), ex);

        return getModelAndView(request, ex, GENERIC_ERROR_PAGE);
    }

    private ModelAndView getModelAndView(HttpServletRequest request, Exception ex, String redirectPage) {
        ModelAndView model = new ModelAndView(redirectPage);
        model.addObject("message", ex.getMessage());

        return model;
    }
}
