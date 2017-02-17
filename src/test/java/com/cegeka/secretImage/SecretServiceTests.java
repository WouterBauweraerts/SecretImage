package com.cegeka.secretImage;

import com.cegeka.secretImage.domain.models.SecretPicture;
import com.cegeka.secretImage.domain.repos.SecretRepo;
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
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecretServiceTests {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @InjectMocks
    private SecretService secretService;

    @Mock
    private SecretRepo secretRepo;

    @Test
    public void addSecretPicture_CallsSecretRepo_addSecretPicture() throws Exception{
        Object picture=new Object();

        secretService.addSecretPicture(0, picture);

        verify(secretRepo).addSecretPicture(new SecretPicture(0,picture));
    }

    @Test
    public void deleteSecretPicture_CallsSecretRepo_deleteSecretPicture() throws Exception{
        secretService.deleteSecretPicture(0);

        verify(secretRepo).deleteSecretPicture(0);
    }

    @Test
    public void getRandomSecretPicture_CallsSecretRepo_getRandomSecretPicture() throws Exception{
        secretService.getRandomSecretPicture();

        verify(secretRepo).getRandomSecretPicture();
    }

    @Test
    public void getRandomSecretPicture_ReturnsRandomSecretPicture() throws Exception{
        int pineapple=0;
        Object picture=new Object();
        SecretPicture secretPicture = new SecretPicture(pineapple,picture);
        when(secretRepo.getRandomSecretPicture()).thenReturn(secretPicture);

        assertThat(secretService.getRandomSecretPicture().getClass().toString().equals("SecretPicture"));


    }
}
