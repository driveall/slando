package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private static final String MAIN_URL = "/main";
    private static final String MAIN = "main";
    private static final String EXIT = "exit";
    private static final String USER = "user";
    
    @Autowired
    private UserService userService;

    @RequestMapping(name = MAIN_URL, method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request,
            @RequestParam(name = EXIT, required = false) String exit) {
        User user = userService.getUserFromSession(request.getSession());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(MAIN);
        modelAndView.addObject(USER, user);
        return modelAndView;
    }
}