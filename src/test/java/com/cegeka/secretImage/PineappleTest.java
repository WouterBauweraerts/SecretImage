package com.cegeka.secretImage;

import com.cegeka.secretImage.controllers.PineappleController;
import com.cegeka.secretImage.domain.models.Pineapple;
import com.cegeka.secretImage.domain.repos.PineappleRepo;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wouterba on 17/02/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PineappleTest {
    @Autowired
    private PineappleController controller;
    @Autowired
    private PineappleRepo repo;

    @Test
    public void addNewPineapple_RepoContainsPineapple() {
        Pineapple pineapple = new Pineapple("Seppe", "abc".hashCode());
        controller.addPineapple("Seppe", "abc");

        Assert.assertTrue(repo.ReadAllPineapples().contains(pineapple));
    }

    @Test
    public void addNewPineapple_NameIsEmptyString_ReturnsBadRequest() {
        Pineapple pineapple = new Pineapple("", "abc".hashCode());
        controller.addPineapple("", "abc");

        Assert.assertFalse(repo.ReadAllPineapples().contains(pineapple));
        Assert.assertEquals(controller.addPineapple("", "abc").getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void addNewPineapple_PasswordIsEmptyString_ReturnsBadRequest() {
        Pineapple pineapple = new Pineapple("abc", "".hashCode());
        controller.addPineapple("abc", "");

        Assert.assertFalse(repo.ReadAllPineapples().contains(pineapple));
        Assert.assertEquals(controller.addPineapple("abc", "").getStatusCode(), HttpStatus.BAD_REQUEST);
    }

}
