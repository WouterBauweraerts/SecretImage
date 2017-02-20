package com.cegeka.secretImage.services;

import com.cegeka.secretImage.controllers.SecretController;
import com.cegeka.secretImage.domain.models.SecretPictureOfTheDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private SecretPictureOfTheDay secretPictureOfTheDay;

    @Autowired
    private SecretController secretController;

    public SecretPictureOfTheDay getSecretPicture() {
        return secretPictureOfTheDay;
    }

    public void createNewGame() {
        secretPictureOfTheDay=new SecretPictureOfTheDay(secretController.getRandomSecretPicture());
    }
}
