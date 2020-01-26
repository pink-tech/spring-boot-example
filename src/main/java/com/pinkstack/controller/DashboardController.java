package com.pinkstack.controller;

import com.pinkstack.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    //Sample URL - localhost:8080/getAllUsers
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView();
        model.addObject("users", userDao.getAllUsers());
        model.addObject("usersView", true);
        model.setViewName("dashboard");
        return model;
    }

    //Sample URL - localhost:8080/getAllUserNames
    @RequestMapping(value = "/getAllUserNames", method = RequestMethod.GET)
    public ModelAndView getAllUserNames() {
        ModelAndView model = new ModelAndView();
        model.addObject("userNames", userDao.getAllUserNames());
        model.addObject("userNamesView", true);
        model.setViewName("dashboard");
        return model;
    }

    //Here "name" is a path parameter
    //Sample URL - localhost:8080/getUserByName/John%20Doe
    @RequestMapping(value = "/getUserByName/{name}", method = RequestMethod.GET)
    public ModelAndView getUserByName(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", userDao.getUserByName(name));
        model.addObject("userProfile", true);
        model.setViewName("dashboard");
        return model;
    }

    //Here "id" is a request parameter
    //Sample URL - http://localhost:8080/getUserById?id=0
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public ModelAndView getUserById(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        model.addObject("user", userDao.getUserById(id));
        model.addObject("userProfile", true);
        model.setViewName("dashboard");
        return model;
    }

}