package com.cegeka.secretImage;

import com.cegeka.secretImage.controllers.PineappleController;
import com.cegeka.secretImage.domain.models.Pineapple;
import com.cegeka.secretImage.domain.repos.PineappleRepo;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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

        Assert.assertTrue(repo.readAllPineapples().contains(pineapple));
    }

    @Test
    public void addNewPineapple_NameIsEmptyString_ReturnsBadRequest() {
        Pineapple pineapple = new Pineapple("", "abc".hashCode());
        controller.addPineapple("", "abc");

        Assert.assertFalse(repo.readAllPineapples().contains(pineapple));
        Assert.assertEquals(controller.addPineapple("", "abc").getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void addNewPineapple_PasswordIsEmptyString_ReturnsBadRequest() {
        Pineapple pineapple = new Pineapple("abc", "".hashCode());
        controller.addPineapple("abc", "");

        Assert.assertFalse(repo.readAllPineapples().contains(pineapple));
        Assert.assertEquals(controller.addPineapple("abc", "").getStatusCode(), HttpStatus.BAD_REQUEST);

    }

    @Test
    public void addNewPineapple_PineappleWithThisNameAlreadyExists_ReturnsHttpStatusCONFLICT(){
        Assert.assertEquals(HttpStatus.CONFLICT,controller.addPineapple("Seppe", "lskfjqdflkjh").getStatusCode());
    }

    @Test
    public void deleteExistingPineapple_ReturnsHttpStatusOk(){
        controller.addPineapple("Seppe", "ljksdl");
        Assertions.assertThat(controller.deletePineapple("Seppe").getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void deleteNonExistingPineapple_ReturnsBadRequest(){
        Assertions.assertThat(controller.deletePineapple("SDFLKSJDFL").getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void deletePineapple_EmptyNameString_ReturnsBadRequest(){
        Assertions.assertThat(controller.deletePineapple("").getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void readPineapple_returnsExpectedPineapple(){
        Pineapple pa1, pa2;
        pa1 = new Pineapple("azerty", "qwerty".hashCode());
        controller.addPineapple("azerty", "qwerty");
        pa2 = controller.getPineapple("azerty").getBody();
        Assertions.assertThat(pa1).isEqualTo(pa2);
    }
}
