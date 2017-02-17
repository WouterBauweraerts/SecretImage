package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.services.PineappleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class GameController {
    @RestController
    @RequestMapping("/game")

    @Autowired
    private PineappleController pineappleController;
    @Autowired
    private SecretController secretController;
    @Autowired
    private ExceptionController exceptionController;
    @Autowired
    private LoginController loginController;





}
