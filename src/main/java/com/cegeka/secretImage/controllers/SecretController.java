package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.services.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/secret")
public class SecretController {
    @Autowired
    private SecretService secretService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addSecretPicture(int pineapple, BufferedImage picture){
        secretService.addSecretPicture(pineapple, picture);
    }
}