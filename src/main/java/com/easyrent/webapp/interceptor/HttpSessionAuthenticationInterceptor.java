package com.easyrent.webapp.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by sabir.salman on 4/26/15.
 */

public class HttpSessionAuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(HttpSessionAuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        log.debug("Intercepting requests now");

        HttpSession session = request.getSession();
        String requestedUri = request.getRequestURI();

        if (!isAuthenticatedUser(session) && isLoggedInUserAccessiblePage(requestedUri)) {
            response.sendRedirect("/EasyRent/login");

            return false;
        } else if (isAuthenticatedUser(session) && isNonLoggedInUserAccessiblePage(requestedUri)) {
            response.sendRedirect("/EasyRent/home");

            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
    }

    public static boolean isAuthenticatedUser(HttpSession session) {

        return (session != null && session.getAttribute("user") != null);
    }

    private boolean isLoggedInUserAccessiblePage(String requestedUri) {

        return requestedUri.contains("logout");
    }

    private boolean isNonLoggedInUserAccessiblePage(String requestedUri) {

        return (requestedUri.contains("login") || requestedUri.contains("signup"));
    }
}


