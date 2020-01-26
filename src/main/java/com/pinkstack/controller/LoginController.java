package com.pinkstack.controller;

import com.pinkstack.dao.UserDao;
import com.pinkstack.model.SessionData;
import com.pinkstack.model.User;
import com.pinkstack.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.pinkstack.config.Constants.EMAIL_ID;
import static com.pinkstack.config.Constants.SESSION_ID;

@Controller
public class LoginController {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    @Autowired
    private SessionService sessionService;

    //Sample URL - localhost:8080/login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    //use MD5 for password
    @RequestMapping(value = "/validateAndLogin", method = RequestMethod.POST)
    public ModelAndView validateAndLogin(@ModelAttribute("loggingUser") User user, HttpSession httpSession) {
        System.out.println("...validating " + user.getEmail() + user.getPassword());
        boolean isAuthenticationSuccessful = userDao.validateEmailIdAndPassword(user.getEmail(), user.getPassword());
        ModelAndView model = new ModelAndView();
        if(isAuthenticationSuccessful) {
            Integer sessionId = sessionService.createAndGetSessionId(user.getEmail());
            System.out.println("...authenticated user " + user.getEmail());

            //session attributes will be available across pages / redirects
            httpSession.setAttribute(EMAIL_ID, user.getEmail());
            httpSession.setAttribute(SESSION_ID, sessionId);

            //model attributes will be available only in the current view
            model.addObject(EMAIL_ID, user.getEmail());
            model.addObject(SESSION_ID, sessionId);
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/destroySessionAndLogout", method = RequestMethod.POST)
    public String destroySessionAndLogout(@ModelAttribute("loggedInUser") SessionData sessionData, HttpSession httpSession) {
        //No need for sending session data separately. This is just for example to show how to send hidden fields from Form.
        System.out.println("...logging out " + sessionData.getEmail() + sessionData.getSessionId());
        System.out.println("..." + httpSession.getAttribute(EMAIL_ID) + httpSession.getAttribute(SESSION_ID));

        sessionService.deleteSessionId(sessionData.getEmail());
        httpSession.removeAttribute(SESSION_ID);
        httpSession.removeAttribute(EMAIL_ID);
        return "redirect:/login";
    }
}

//TODO:
//model.addObject("request", request.getCookies());
//<div class="col-md-4 text-center">${request}</div>