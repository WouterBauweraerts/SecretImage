package com.cegeka.secretImage.domain.repos;

import com.cegeka.secretImage.domain.models.SecretPictureOfTheDay;

public class SecretOfTheDayRepo {
    private SecretPictureOfTheDay secretPictureOfTheDay;

    public SecretOfTheDayRepo() {}

    public SecretPictureOfTheDay getSecretPicture() {
        return secretPictureOfTheDay;
    }

    public void addSecretPicture(SecretPictureOfTheDay secretPictureOfTheDay){
        this.secretPictureOfTheDay=secretPictureOfTheDay;
    }
}
