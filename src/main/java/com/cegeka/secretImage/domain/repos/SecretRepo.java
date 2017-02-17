package com.cegeka.secretImage.domain.repos;

import com.cegeka.secretImage.domain.models.SecretPicture;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SecretRepo {

    private Map<Integer,SecretPicture> secretPictures;

    public SecretRepo() {
        this.secretPictures = new HashMap<Integer,SecretPicture>();
    }

    public void addSecretPicture(SecretPicture secretPicture){
        secretPictures.put(secretPicture.getPineapple(),secretPicture);
    }

    public void deleteSecretPicture(int pineapple) {
        secretPictures.remove(pineapple);
    }

    public SecretPicture getRandomSecretPicture() throws UnsupportedOperationException{
        int size = secretPictures.size();
        if(size!=0){
            throw new UnsupportedOperationException("No secret pictures available.");
        }
        int item = new Random().nextInt(size);
        return new ArrayList<SecretPicture>(secretPictures.values()).get(item);
    }

    public boolean SecretPictureAlreadyExists(int pineapple) {
        return secretPictures.containsKey(pineapple);

    }
}
