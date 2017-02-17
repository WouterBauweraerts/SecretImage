package com.cegeka.secretImage.domain.models;

import javax.xml.bind.ValidationException;
import java.io.Serializable;

/**
 * Created by wouterba on 17/02/2017.
 */
public class Pineapple implements Serializable {
    private String name;
    private int password;
    private int score;

    public Pineapple(String name, int password) {
        this.name = name;
        this.password = password;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int pineapplePasswordHash(){
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pineapple pineapple = (Pineapple) o;
        return this.name.equals(pineapple.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public boolean validate() throws ValidationException{
        if (name == null || name.length() == 0){
            throw new ValidationException("Field name is required");
        }
        if (password == "".hashCode()){
            throw new ValidationException("Password is required");
        }
        return true;
    }
}
