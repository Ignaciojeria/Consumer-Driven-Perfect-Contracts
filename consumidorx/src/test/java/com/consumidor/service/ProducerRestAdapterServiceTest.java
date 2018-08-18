package com.consumidor.service;

import com.consumidor.request.CreateSoftwareFactoryRequestBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")
public class ProducerRestAdapterServiceTest {

    @Autowired
    private ProducerRestAdapterService producerRestAdapterService;

    @Test
    public void  inyectaDependenciaTest(){
      System.out.println(producerRestAdapterService.inyectaDependencia());
    }

    /**
     * Debemos pasar esta prueba mediante stubs
     */
    @Test
    public void createSoftwareFactory(){
        CreateSoftwareFactoryRequestBody createSoftwareFactoryRequestBody=new CreateSoftwareFactoryRequestBody();
        createSoftwareFactoryRequestBody.setName("Fabrica de sofware Beta");
        createSoftwareFactoryRequestBody.setDescription("Dedicados a crear software de calidad");
        producerRestAdapterService.createSoftwareFactory(createSoftwareFactoryRequestBody);
    }


}
