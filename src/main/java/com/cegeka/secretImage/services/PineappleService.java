package com.cegeka.secretImage.services;

import com.cegeka.secretImage.domain.models.Pineapple;
import com.cegeka.secretImage.domain.repos.PineappleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Collections;
import java.util.List;

@Service
public class PineappleService {
    @Autowired
    private PineappleRepo repo;

    public List<Pineapple> GetAllPineapples() {
        return Collections.unmodifiableList(repo.ReadAllPineapples());
    }

    public void addPineapple(String name, String password) throws ValidationException{
        Pineapple newPineapple = new Pineapple(name, password.hashCode());
        if(newPineapple.validate()) {
            repo.addPineapple(newPineapple);
        }
    }
}
