package com.cegeka.secretImage;

import com.cegeka.secretImage.controllers.GameController;
import com.cegeka.secretImage.controllers.LoginController;
import com.cegeka.secretImage.controllers.PineappleController;
import com.cegeka.secretImage.controllers.SecretController;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameControllerTests {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @InjectMocks
    //private SecretController secretController;
    //private LoginController loginController;
    //private PineappleController pineappleController;
    private GameController gameController;

    //@Mock


    @Test
    public void createNewGame_createsANewSecretGame() throws Exception{
        gameController.createNewGame();
    }

    @Test
    public void createNewGameDay_createsANewSecretGameDay() throws Exception{
        gameController.createNewGameDay();
    }

    @Test
    public void LoginOfPineapple_callsLoginController() throws Exception{
        gameController.LoginOfPineapple();
    }

    @Test
    public void addSecretPicture_callsSecretController() throws Exception{
        BufferedImage picture=null;
        try{
            picture= ImageIO.read(new File("SecretPictures/test.jpg"));
        } catch(Exception e){
            e.printStackTrace();
        }
        gameController.addSecretPicture(0, picture);
    }

    @Test
    public void deleteSecretPicture_callsSecretController() throws Exception{
        gameController.deleteSecretPicture(0);
    }

    @Test
    public void getSecretPicture_FirstGetSecretPictureOfTheDay_callsSecretController_ReturnsNewRandomSecretPicture() throws Exception{
        gameController.getSecretPicture();
    }

    @Test
    public void getSecretPicture_NotFirstGetSecretPictureOfTheDay_ReturnsCurrentSecretPicture() throws Exception{
        gameController.getSecretPicture();
    }

    @Test
    public void startVoting() throws Exception{
        gameController.startVoting();
    }

    @Test
    public void endVoting() throws Exception {
        gameController.endVoting();
    }
}
