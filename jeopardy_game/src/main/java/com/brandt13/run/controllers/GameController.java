package com.brandt13.run.controllers;

import com.brandt13.run.model.Category;
import com.brandt13.run.model.Clue;
import com.brandt13.run.model.User;
import com.brandt13.run.service.GameService;
import com.brandt13.run.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/admin/game", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User admin = userService.findUserByEmail(auth.getName());

        Clue[][] userClues = gameService.singleJeopardy();

//        String[] userCategories = new String[5];
//        for (int i = 0; i < 5; i++) {
//            userCategories[i] = userClues[i][0].getCategory().getTitle();
//        }

        modelAndView.addObject("welcome", "Welcome " + admin.getEmail());
        modelAndView.addObject("adminMessage","Content Available for Users with User Role");
        modelAndView.addObject("userClues", userClues);
        modelAndView.setViewName("admin/game");
        return modelAndView;
    }
}
