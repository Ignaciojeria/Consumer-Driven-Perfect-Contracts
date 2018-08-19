package com.consumidor.resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ProducerRestAdapterResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreatecreateSoftwareFactory() throws Exception{
        String body="{\"name\":\"Sofware AA company\",\"description\":\"Compania de desarrollo de software en estado beta\"}";

        mockMvc.perform(
                post("/consumer")
                        .contentType(APPLICATION_JSON_UTF8_VALUE)
                        .content(body))
                //.andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                //Pasa el test siempre y cuando se resuelva correctamente la solicitud Http al endPoint /account
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                //El retorno del Json de la solicitud http espera un objeto que dentro se sus atributos clave:valor contiene: ("nombre":"ignacio")
                .andExpect(jsonPath("description",is("Compania de desarrollo de software en estado beta")))
                .andExpect(jsonPath("name",is("Sofware AA company")));
    }

}
