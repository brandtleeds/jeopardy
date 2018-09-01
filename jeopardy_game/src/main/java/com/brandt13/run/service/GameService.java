package com.brandt13.run.service;

import com.brandt13.run.exceptions.GeneralException;
import com.brandt13.run.mappers.UserMapper;
import com.brandt13.run.model.Category;
import com.brandt13.run.model.Clue;
import com.brandt13.run.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Random;

@Service("gameService")
public class GameService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RestTemplate restTemplate;

    User user;

    public void playJeopardy(){


    }

    public Clue[][] singleJeopardy(){

        Clue[][] userClues = new Clue[5][5];

        for(int i = 0; i < 5; i++) {

            Random categoryNumber = new Random();
            int highCN = 18000;
            int lowCN = 1;
            int randomCN = categoryNumber.nextInt(highCN - lowCN) + lowCN;

            for (int j = 0; j < 5; j++) {

                int value = (j+1) * 100;

                Clue[] clues;

                do {

                    String clueQuery = "http://jservice.io/api/clues?value=" + value + "&category=" + randomCN;
                    clues = restTemplate.getForObject(clueQuery, Clue[].class);

                    if (clues.length == 0){
                        randomCN = categoryNumber.nextInt(highCN - lowCN) + lowCN;
                    }
                } while (clues.length == 0);

                int numClues = clues.length;

                if (numClues == 1) {
                    userClues[i][j] = clues[0];
                } else {

                    Random clueNumber = new Random();
                    int randomClue = clueNumber.nextInt(numClues - 1) + 1;

                    if (randomClue == 1){
                        userClues[i][j] = clues[0];
                    }
                    else if (randomClue == 2){
                        userClues[i][j] = clues[1];
                    } else {
                        userClues[i][j] = clues[randomClue - 1];
                    }
                }
            }
        }
        return userClues;
    }
}
