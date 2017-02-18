package com.cegeka.secretImage.services;

import com.cegeka.secretImage.controllers.SecretController;
import com.cegeka.secretImage.domain.models.SecretPictureOfTheDay;
import com.cegeka.secretImage.domain.repos.SecretOfTheDayRepo;
import com.cegeka.secretImage.domain.repos.SecretRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private SecretOfTheDayRepo secretOfTheDayRepo;
    @Autowired
    private SecretController secretController;

    public SecretPictureOfTheDay getSecretPicture() {
        return secretOfTheDayRepo.getSecretPicture();
    }

    public void createNewGameDay() {
        secretOfTheDayRepo=new SecretOfTheDayRepo();
        secretOfTheDayRepo.addSecretPicture(new SecretPictureOfTheDay(secretController.getRandomSecretPicture()));
    }

    public void createNewGame() {
    }

    public void startVoting() {
    }

    public void endVoting() {
    }
}
