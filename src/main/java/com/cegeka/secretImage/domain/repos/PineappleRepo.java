package com.cegeka.secretImage.domain.repos;

import com.cegeka.secretImage.domain.models.Pineapple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class PineappleRepo {

    private Set<Pineapple> pineapples;

    public PineappleRepo() {
        this.pineapples = new HashSet<>();
    }

    public List<Pineapple> readAllPineapples() {
        return new ArrayList<>(pineapples);
    }

    public void addPineapple(Pineapple newPineapple) {
        pineapples.add(newPineapple);
    }

    public boolean deletePineapple(String name) {
        Optional<Pineapple> pineapple = readPineapple(name);
        return pineapple.isPresent()?pineapples.remove(pineapple.get()):false;
    }

    public Optional<Pineapple> readPineapple(String name) {
        return pineapples.stream()
                .filter(p->p.getName().equals(name))
                .findFirst();
    }
}
