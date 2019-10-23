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
import java.util.Arrays;
import java.util.Random;


//  This is the GameService. It calls the jService API and finds categories of clues,
//  saving them to a 25-question, 5x5 array. These are then displayed to the user in
//  the view.


@Service("gameService")
public class GameService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RestTemplate restTemplate;

    User user;

    public Clue[][] singleJeopardy(){

        Clue[][] userClues = new Clue[5][5];

        for (int i = 0; i < 5; i++) {

            Random categoryNumber = new Random();
            int highCN = 18000;
            int lowCN = 1;
            int randomCN = categoryNumber.nextInt(highCN - lowCN) + lowCN;

            Clue[] clues;
            Clue[] blankClue = new Clue[0];
            Arrays.fill(blankClue, null);

            do {

                String clueQuery = "http://jservice.io/api/clues?category=" + randomCN;

                clues = restTemplate.getForObject(clueQuery, Clue[].class);

                for(int x = 0; x < clues.length; x++){

                    if (clues[x].getValue() == 0 || (   clues[x].getValue() != 100 && clues[x].getValue() != 200 &&
                                                        clues[x].getValue() != 300 && clues[x].getValue() != 400 &&
                                                        clues[x].getValue() != 500
                                                                                     )){
                        clues = blankClue;
                        break;
                    }
                }

                if (clues.length == 0){
                    randomCN = categoryNumber.nextInt(highCN - lowCN) + lowCN;
                }

            } while (clues.length == 0);

            for (int j = 0; j < 5; j++) {

                int numClues = 0;
                int value = (j+1) * 100;

                for (int x = 0; x < clues.length; x++){
                    if (clues[x].getValue() == value) {
                        numClues++;

                    }
                }

                Clue[] currentValueArray = new Clue[numClues];
                int y = 0;

                for (int x = 0; x < clues.length; x++){
                    if (clues[x].getValue() == value) {
                        currentValueArray[y] = clues[x];
                        y++;
                    }
                }

                if (numClues == 1) {
                    String question = currentValueArray[0].getQuestion().toUpperCase();
                    String replaced = question.replace("'", "\'");
                    currentValueArray[0].setQuestion(replaced);

                    userClues[i][j] = currentValueArray[0];

                } else {

                    Random clueNumber = new Random();
                    int randomClue = clueNumber.nextInt(numClues - 1) + 1;

                    if (randomClue == 1) {
                        String question = currentValueArray[0].getQuestion().toUpperCase();
                        String replaced = question.replace("'", "\'");
                        currentValueArray[0].setQuestion(replaced);

                        userClues[i][j] = currentValueArray[0];

                    } else if (randomClue == 2) {

                        String question = currentValueArray[1].getQuestion().toUpperCase();
                        String replaced = question.replace("'", "\'");
                        currentValueArray[1].setQuestion(replaced);

                        userClues[i][j] = currentValueArray[1];
                    } else {

                        String question = currentValueArray[randomClue - 1].getQuestion().toUpperCase();
                        String replaced = question.replace("'", "\'");
                        currentValueArray[randomClue - 1].setQuestion(replaced);

                        userClues[i][j] = currentValueArray[randomClue - 1];
                    }
                }
            }
        }

        return userClues;
    }

    public Clue[][] doubleJeopardy(){

        Clue[][] userClues = new Clue[5][5];

        for (int i = 0; i < 5; i++) {

            Random categoryNumber = new Random();
            int highCN = 18000;
            int lowCN = 1;
            int randomCN = categoryNumber.nextInt(highCN - lowCN) + lowCN;

            Clue[] clues;
            Clue[] blankClue = new Clue[0];
            Arrays.fill(blankClue, null);

            do {
                String clueQuery = "http://jservice.io/api/clues?category=" + randomCN;

                clues = restTemplate.getForObject(clueQuery, Clue[].class);

                for(int x = 0; x < clues.length; x++){

                    if (clues[x].getValue() == 0 || (   clues[x].getValue() != 200 && clues[x].getValue() != 400 &&
                                                        clues[x].getValue() != 600 && clues[x].getValue() != 800 &&
                                                        clues[x].getValue() != 1000
                                                                                        )){
                        clues = blankClue;
                        break;
                    }
                }

                if (clues.length == 0){
                    randomCN = categoryNumber.nextInt(highCN - lowCN) + lowCN;
                }
            } while (clues.length == 0);

            for (int j = 0; j < 5; j++) {

                int numClues = 0;
                int value = (j+1) * 200;

                for (int x = 0; x < clues.length; x++){
                    if (clues[x].getValue() == value) {
                        numClues++;

                    }
                }

                Clue[] currentValueArray = new Clue[numClues];
                int y = 0;

                for (int x = 0; x < clues.length; x++){
                    if (clues[x].getValue() == value) {
                        currentValueArray[y] = clues[x];
                        y++;
                    }
                }

                if (numClues == 1) {
                    String question = currentValueArray[0].getQuestion().toUpperCase();
                    String replaced = question.replace("'", "\'");
                    currentValueArray[0].setQuestion(replaced);

                    userClues[i][j] = currentValueArray[0];

                } else {

                    Random clueNumber = new Random();
                    int randomClue = clueNumber.nextInt(numClues - 1) + 1;

                    if (randomClue == 1) {
                        String question = currentValueArray[0].getQuestion().toUpperCase();
                        String replaced = question.replace("'", "\'");
                        currentValueArray[0].setQuestion(replaced);

                        userClues[i][j] = currentValueArray[0];

                    } else if (randomClue == 2) {

                        String question = currentValueArray[1].getQuestion().toUpperCase();
                        String replaced = question.replace("'", "\'");
                        currentValueArray[1].setQuestion(replaced);

                        userClues[i][j] = currentValueArray[1];
                    } else {

                        String question = currentValueArray[randomClue - 1].getQuestion().toUpperCase();
                        String replaced = question.replace("'", "\'");
                        currentValueArray[randomClue - 1].setQuestion(replaced);

                        userClues[i][j] = currentValueArray[randomClue - 1];
                    }
                }
            }
        }

        return userClues;
    }

    public Clue[] finalJeopardy(){

        Clue[] finalClue;

        String clueQuery = "http://jservice.io/api/random";

        finalClue = restTemplate.getForObject(clueQuery, Clue[].class);

        String question = finalClue[0].getQuestion().toUpperCase();
        String replaced = question.replace("'","\'");
        finalClue[0].setQuestion(replaced);

        return finalClue;
    }

}

