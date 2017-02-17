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
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;
import java.io.ObjectInputStream;

/**
 * Created by wouterba on 17/02/2017.
 */
@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private Context context;

    @Autowired
    private PineappleService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> loginUser(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password){
        boolean loginOk = service.loginUser(name, password);
        if (loginOk){
            context.setUser(name);
            return new ResponseEntity<String>("Login ok",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Login failed: check your name and password pineapple", HttpStatus.UNAUTHORIZED);
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
/*@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class ShoppingCart implements Serializable{
...
}*/