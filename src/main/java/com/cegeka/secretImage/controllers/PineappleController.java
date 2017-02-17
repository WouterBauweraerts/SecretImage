package com.cegeka.secretImage.controllers;

import com.cegeka.secretImage.domain.models.Pineapple;
import com.cegeka.secretImage.services.PineappleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pineapple")
public class PineappleController {
    @Autowired
    private PineappleService service;

    /*@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Pineapple>> GetAllPineapples(){
        List<Pineapple> pineapples = service.GetAllPineapples();
        return CreateResponse(pineapples);
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Pineapple> GetAllPineapples(){
        List<Pineapple> pineapples = service.GetAllPineapples();
        return pineapples;
    }

    private ResponseEntity<List<Pineapple>> CreateResponse(List<Pineapple> pineapples) {
        return new ResponseEntity<>(pineapples, pineapples.size()==0? HttpStatus.NO_CONTENT:HttpStatus.OK);
    }
}
