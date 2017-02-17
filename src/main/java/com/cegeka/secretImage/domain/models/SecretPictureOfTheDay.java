package com.cegeka.secretImage.domain.models;

import java.time.LocalDate;

public class SecretPictureOfTheDay {
    private SecretPicture secretPicture;
    private LocalDate date;

    public SecretPictureOfTheDay(SecretPicture secretPicture) {
        this.secretPicture = secretPicture;
        this.date=LocalDate.now();
    }


}
