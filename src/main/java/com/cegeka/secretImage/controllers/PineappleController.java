package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.domain.models.Pineapple;
import com.cegeka.secretImage.services.PineappleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/pineapple")
public class PineappleController {
    @Autowired
    private PineappleService service;

    @Autowired
    private ExceptionController exceptionController;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Pineapple>> GetAllPineapples(){
        List<Pineapple> pineapples = service.GetAllPineapples();
        return CreateResponse(pineapples);
    }


    private ResponseEntity<List<Pineapple>> CreateResponse(List<Pineapple> pineapples) {
        return new ResponseEntity<>(pineapples, pineapples.size()==0? HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addPineapple(@RequestParam(name = "name")String name, @RequestParam(name = "password") String password) {
        try {
            service.addPineapple(name, password);
            return new ResponseEntity(HttpStatus.OK);
        } catch (ValidationException e) {
            return exceptionController.validationErrorHandler(e);
        }
    }
}
