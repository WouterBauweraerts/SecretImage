package com.cegeka.secretImage.services;

import com.cegeka.secretImage.controllers.SecretController;
import com.cegeka.secretImage.domain.models.Pineapple;
import com.cegeka.secretImage.domain.models.SecretPictureOfTheDay;
import com.cegeka.secretImage.domain.repos.SecretPictureOfTheDayRepo;
import com.cegeka.secretImage.infrastructure.PineAppleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private PineappleService pineappleService;

    private SecretPictureOfTheDay secretPictureOfTheDay;

    @Autowired
    private SecretPictureOfTheDayRepo repo;

    @Autowired
    private SecretController secretController;

    public SecretPictureOfTheDay getSecretPicture() {
        return secretPictureOfTheDay;
    }

    public void playGame() {
        if (secretPictureOfTheDay == null || !secretPictureOfTheDay.getDate().equals(LocalDate.now())) {
            secretPictureOfTheDay = new SecretPictureOfTheDay(secretController.getRandomSecretPicture());
            repo.addSPOTD(secretPictureOfTheDay);
        }
    }

    public void addVote(String userName, String pineappleName) {
        Optional<Pineapple> user = pineappleService.getPineapple(userName);
        Optional<Pineapple> pineapple = pineappleService.getPineapple(pineappleName);

        if (!(user.isPresent() && pineapple.isPresent())){
            throw new PineAppleNotFoundException("Pineapple not found");
        }
        secretPictureOfTheDay.addVote(user.get(), pineapple.get());
        
    }
}
