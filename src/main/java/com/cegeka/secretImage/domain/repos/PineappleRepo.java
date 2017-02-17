package com.cegeka.secretImage.domain.repos;

import com.cegeka.secretImage.domain.models.Pineapple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PineappleRepo {

    private Set<Pineapple> pineapples;

    public PineappleRepo() {
        this.pineapples = new HashSet<>();
        //InitialiseHc();
    }

    @PostConstruct
    private void InitialiseHc() {
        pineapples.add(new Pineapple("Wouter", 0));
        pineapples.add(new Pineapple("Lil' Billy",1));
        pineapples.add(new Pineapple("Sanne",2));
        pineapples.add(new Pineapple("Jens",3));
        pineapples.add(new Pineapple("Elise",4));
        pineapples.add(new Pineapple("Kevin S",5));
        pineapples.add(new Pineapple("Steven", 6));
        pineapples.add(new Pineapple("Pieter", 7));
        pineapples.add(new Pineapple("Paulien", 8));
        pineapples.add(new Pineapple("Xan", 9));
    }

    public List<Pineapple> ReadAllPineapples() {
        return new ArrayList<>(pineapples);
    }

    public void addPineapple(Pineapple newPineapple) {
        pineapples.add(newPineapple);
    }
}
