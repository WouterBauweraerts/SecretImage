package com.cegeka.secretImage;

import com.cegeka.secretImage.controllers.LoginController;
import com.cegeka.secretImage.controllers.PineappleController;
import com.cegeka.secretImage.session.Context;
import org.assertj.core.api.Assertions;
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
public class LoginControllerTest {
    @Autowired
    private Context context;

    @Autowired
    private LoginController loginController;

    @Autowired
    private PineappleController pineappleController;

    @Test
    public void registeredUserLogin_PasswordOk_ReturnsHttp200() {
        pineappleController.addPineapple("Wouter", "azerty");
        Assertions.assertThat(loginController.loginUser("Wouter", "azerty").getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(context.getUser()).isEqualTo("Wouter");
    }

    @Test
    public void unregisteredUserLogin_ReturnsHttp400() {
        Assertions.assertThat(context.getUser()).isEqualTo(null);
        Assertions.assertThat(loginController.loginUser("David", "azerty").getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void logout_UserLogsOut_ContextUserEqualsNull(){
        pineappleController.addPineapple("Wouter", "azerty");
        loginController.loginUser("Wouter", "azerty");
        Assertions.assertThat(loginController.logout().getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(context.getUser()).isNull();
    }

    @Test
    public void logoutUnregisteredUser_UserLogsOut_ContextUserEqualsNull(){
        loginController.loginUser("David", "azerty");
        Assertions.assertThat(loginController.logout().getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(context.getUser()).isNull();
    }
}
