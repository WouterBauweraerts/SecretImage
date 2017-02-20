package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.services.PineappleService;
import com.cegeka.secretImage.session.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private Context context;

    @Autowired
    private PineappleService service;

    @RequestMapping(method = RequestMethod.POST)
    public /*ResponseEntity<String>*/RedirectView loginUser(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password){
        //return LoginSucceeded(name, service.loginUser(name, password));
        return new RedirectView("scores.html");
    }

    private ResponseEntity<String> LoginSucceeded(@RequestParam(name = "name") String name, boolean loginOk) {
        if (loginOk){
            context.setUser(name);
            return new ResponseEntity<>("redirect:scores.html", HttpStatus.OK);
        }
        return new ResponseEntity<>("Login failed: check your name and password pineapple", HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity logout(){
        String user = context.getUser();
        if (user == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        context.setUser(null);
        return new ResponseEntity(HttpStatus.OK);
    }
}