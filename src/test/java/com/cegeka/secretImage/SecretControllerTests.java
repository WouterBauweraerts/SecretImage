package com.cegeka.secretImage;

import com.cegeka.secretImage.controllers.SecretController;
import com.cegeka.secretImage.services.SecretService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecretControllerTests {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @InjectMocks
    private SecretController secretController;

    @Mock
    private SecretService secretService;

    @Test
    public void addSecretPicture_CallsSecretService_addSecretPicture() throws Exception{
        int pineapple=0;
        Object picture=new Object();

        secretController.addSecretPicture(pineapple, picture);

        verify(secretService).addSecretPicture(pineapple, picture);
    }
}
