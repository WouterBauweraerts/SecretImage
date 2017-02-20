package com.cegeka.secretImage.domain.repos;

import com.cegeka.secretImage.domain.models.SecretPictureOfTheDay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SecretPictureOfTheDayRepo {
    private List<SecretPictureOfTheDay> secretPictureOfTheDayList;

    public SecretPictureOfTheDayRepo() {
        secretPictureOfTheDayList = Collections.synchronizedList(new ArrayList<>());
    }

    public void addSPOTD(SecretPictureOfTheDay secretPictureOfTheDay) {
        secretPictureOfTheDayList.add(secretPictureOfTheDay);
    }
}
