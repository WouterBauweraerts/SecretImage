package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.domain.models.SecretPicture;
import com.cegeka.secretImage.services.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/secret")
public class SecretController {
    @Autowired
    private SecretService secretService;
    @Autowired
    private ExceptionController exceptionController;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addSecretPicture(int pineapple, BufferedImage picture){
        try {
            secretService.addSecretPicture(pineapple, picture);
            return new ResponseEntity(HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            return exceptionController.unsupportedOperationHandler(e);
        }
    }
    public void deleteSecretPicture(int pineapple){
        secretService.deleteSecretPicture(pineapple);
    }

    public SecretPicture getRandomSecretPicture() throws UnsupportedOperationException{
        return secretService.getRandomSecretPicture();
    }
}