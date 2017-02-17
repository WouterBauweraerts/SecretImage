package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.domain.models.SecretPicture;
import com.cegeka.secretImage.domain.models.SecretPictureOfTheDay;
import com.cegeka.secretImage.services.GameService;
import com.cegeka.secretImage.services.PineappleService;
import com.cegeka.secretImage.services.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private PineappleController pineappleController;
    @Autowired
    private SecretController secretController;
    @Autowired
    private ExceptionController exceptionController;
    @Autowired
    private LoginController loginController;
    @Autowired
    private GameService gameService;


    public SecretPictureOfTheDay getSecretPicture() throws UnsupportedOperationException{
        return gameService.getSecretPicture();
    }


    public void deleteSecretPicture(int pineapple) {
        secretController.deleteSecretPicture(pineapple);
    }

    public void addSecretPicture(int pineapple, BufferedImage picture) {
        secretController.addSecretPicture(pineapple, picture);
    }

    public void createNewGameDay() {
        gameService.createNewGameDay();
    }

    public void createNewGame() {
        gameService.createNewGame();
    }

    public void startVoting() {
        gameService.startVoting();
    }

    public void endVoting() {
        gameService.endVoting();
    }

    public void LoginOfPineapple() {
       // loginController.LoginOfPineapple();
    }
}
