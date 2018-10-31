package com.brandt13.run.controllers;

import com.brandt13.run.mappers.UserMapper;
import com.brandt13.run.model.Clue;
import com.brandt13.run.model.NewHighScore;
import com.brandt13.run.model.User;
import com.brandt13.run.service.GameService;
import com.brandt13.run.service.UserService;
import com.brandt13.run.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;

//
// Different landing pages for the rounds of the game.
//

@RestController
@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    UserService userService;

    @Autowired
    UserServiceImplementation usi;


    @RequestMapping(value="/admin/game", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User admin = userService.findUserByEmail(auth.getName());

        Clue[][] userClues = gameService.singleJeopardy();

        modelAndView.addObject("welcome", "Single Jeopardy | Welcome " + admin.getEmail() + "!");
        modelAndView.addObject("userClues", userClues);
        modelAndView.addObject("admin", admin);


        modelAndView.setViewName("admin/game");
        return modelAndView;
    }

    @RequestMapping(value="/admin/doubleJeopardy", method = RequestMethod.GET)
    public ModelAndView doubleJeopardy(){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User admin = userService.findUserByEmail(auth.getName());

        Clue[][] userClues = gameService.doubleJeopardy();

        modelAndView.addObject("welcome", "Double Jeopardy | Welcome " + admin.getEmail() + "!");
        modelAndView.addObject("userClues", userClues);
        modelAndView.addObject("admin", admin);


        modelAndView.setViewName("admin/doubleJeopardy");
        return modelAndView;
    }

    @RequestMapping(value="/admin/finalJeopardy", method = RequestMethod.GET)
    public ModelAndView finalJeopardy(){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User admin = userService.findUserByEmail(auth.getName());

        Clue[] finalClue = gameService.finalJeopardy();

        modelAndView.addObject("welcome", "Final Jeopardy | Good luck, " + admin.getEmail() + "!");
        modelAndView.addObject("finalClue", finalClue);
        modelAndView.addObject("admin", admin);

        NewHighScore newHighScore = new NewHighScore();
        modelAndView.addObject("newHighScore", newHighScore);


        modelAndView.setViewName("admin/finalJeopardy");
        return modelAndView;
    }

    @RequestMapping(value="/admin/gameComplete", method = RequestMethod.POST)
    public ModelAndView gameComplete(@ModelAttribute("newHighScore") NewHighScore newHighScore){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User admin = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("welcome", "Game Complete! | Thanks for playing, " + admin.getEmail() + "!");
        modelAndView.addObject("admin", admin);

        int high = newHighScore.getNewHigh();

        admin.setHigh_score(high);

        usi.updateUser(admin);


        modelAndView.setViewName("admin/gameComplete");
        return modelAndView;
    }


}
