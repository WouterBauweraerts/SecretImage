package com.cegeka.secretImage.domain.repos;

import com.cegeka.secretImage.domain.models.Pineapple;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PineappleRepo {

    private Set<Pineapple> pineapples;

    public PineappleRepo() {
        this.pineapples = Collections.synchronizedSet(new HashSet<>());
        pineapples.add(new Pineapple("wouter", "azerty".hashCode()));
    }

    public List<Pineapple> readAllPineapples() {
        return Collections.unmodifiableList(new ArrayList<>(pineapples));
    }

    public void addPineapple(Pineapple newPineapple) {
        pineapples.add(newPineapple);
    }

    public boolean deletePineapple(String name) {
        Optional<Pineapple> pineapple = readPineapple(name);
        return pineapple.isPresent() && pineapples.remove(pineapple.get());
    }

    public Optional<Pineapple> readPineapple(String name) {
        return pineapples.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }
}
