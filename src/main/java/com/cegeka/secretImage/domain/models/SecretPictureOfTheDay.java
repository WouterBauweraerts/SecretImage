package com.cegeka.secretImage.domain.models;

import com.cegeka.secretImage.controllers.SecretController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SecretPictureOfTheDay {
    private SecretPicture secretPicture;
    private LocalDate date;
    private Map<Pineapple, Pineapple> votes;


    public SecretPictureOfTheDay(SecretPicture picture) {
        this.secretPicture = picture;
        this.date=LocalDate.now();
        this.votes = new HashMap<>();
    }

    public BufferedImage getSecretPicture() {
        return secretPicture.getPicture();
    }

    public LocalDate getDate() {
        return date;
    }

    public void addVote(Pineapple user, Pineapple pineapple) {
        votes.put(user,pineapple);
    }
}
