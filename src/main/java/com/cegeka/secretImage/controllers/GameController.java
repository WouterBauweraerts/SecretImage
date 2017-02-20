package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.domain.models.SecretPictureOfTheDay;
import com.cegeka.secretImage.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/loadImage")
    public @ResponseBody BufferedImage getSecretPicture() throws UnsupportedOperationException{
        return gameService.getSecretPicture().getSecretPicture();
    }

    @RequestMapping("/vote")
    public void addVote(@RequestParam(name = "user") String userName,
                        @RequestParam(name = "pineapple")String pineappleName){
        gameService.addVote(userName, pineappleName);
    }


/*    public void createNewGameDay() {
        gameService.createNewGameDay();
    }

    public void playGame() {
        gameService.playGame();
    }

    public void startVoting() {
        gameService.startVoting();
    }

    public void endVoting() {
        gameService.endVoting();
    }

    public void LoginOfPineapple() {
       // loginController.LoginOfPineapple();
    }*/
}
