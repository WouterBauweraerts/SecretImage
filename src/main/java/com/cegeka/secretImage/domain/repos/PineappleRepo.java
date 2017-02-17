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
        pineapples.add(new Pineapple("Wouter"));
        pineapples.add(new Pineapple("Lil' Billy"));
        pineapples.add(new Pineapple("Sanne"));
        pineapples.add(new Pineapple("Jens"));
        pineapples.add(new Pineapple("Elise"));
        pineapples.add(new Pineapple("Kevin S"));
        pineapples.add(new Pineapple("Steven"));
        pineapples.add(new Pineapple("Pieter"));
        pineapples.add(new Pineapple("Paulien"));
        pineapples.add(new Pineapple("Xan"));
    }

    public List<Pineapple> ReadAllPineapples() {
        return new ArrayList<>(pineapples);
    }
}
