package com.cegeka.secretImage.domain.models;

import com.cegeka.secretImage.controllers.SecretController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SecretPictureOfTheDay {
    private SecretPicture secretPicture;
    private LocalDate date;
    private Map<Pineapple, Pineapple> votes;

    @Autowired
    private SecretController secretController;

    public SecretPictureOfTheDay(SecretPicture picture) {
        this.secretPicture = picture;
        this.date=LocalDate.now();
        this.votes = new HashMap<>();
    }


}
