package com.cegeka.secretImage.services;

import com.cegeka.secretImage.domain.models.SecretPicture;
import com.cegeka.secretImage.domain.repos.SecretRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretService {
    @Autowired
    private SecretRepo secretRepo;

    public void addSecretPicture(int pineapple, Object picture) throws UnsupportedOperationException{
        if(secretRepo.SecretPictureAlreadyExists(pineapple)){
            throw new UnsupportedOperationException("You already have a secret picture.");
        }
        secretRepo.addSecretPicture(new SecretPicture(pineapple, picture));
    }

    public void deleteSecretPicture(int pineapple){
        secretRepo.deleteSecretPicture(pineapple);
    }

    public SecretPicture getRandomSecretPicture() throws UnsupportedOperationException{
        return secretRepo.getRandomSecretPicture();
    }
}
