package com.cegeka.secretImage.services;

import com.cegeka.secretImage.domain.models.Pineapple;
import com.cegeka.secretImage.domain.repos.PineappleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PineappleService {
    @Autowired
    private PineappleRepo repo;

    public List<Pineapple> GetAllPineapples() {
        return Collections.unmodifiableList(repo.readAllPineapples());
    }

    public void addPineapple(String name, String password) throws ValidationException{
        Pineapple newPineapple = new Pineapple(name, password.hashCode());
        if (repo.readAllPineapples().contains(newPineapple)){
            throw new UnsupportedOperationException("There is another pineaplle with this name. Choose another");
        }
        if(newPineapple.validate()) {
            repo.addPineapple(newPineapple);
        }
    }

    public boolean deletePineapple(String name) {
        return repo.deletePineapple(name);
    }

    public Optional<Pineapple> getPineapple(String name) {
        return repo.readPineapple(name);
    }

    public boolean loginUser(String name, String password) {
        Optional<Pineapple> user = getPineapple(name);
        return checkLoginCredentials(password, user);
    }

    private boolean checkLoginCredentials(String password, Optional<Pineapple> user) {
        return user.isPresent() && password.hashCode() == user.get().pineapplePasswordHash();
    }

}
