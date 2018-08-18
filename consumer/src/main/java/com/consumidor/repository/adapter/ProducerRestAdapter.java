package com.consumidor.repository.adapter;
import com.consumidor.request.CreateSoftwareFactoryRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Repository
public class ProducerRestAdapter {

    @Autowired
    private RestTemplate restTemplate;

    // this value references to domain and port of the microservice as a point of entry for attack to producer end-points
    @Value("${microservice.ms-2-productor.host}")
    private String host;

    /* this method should create a software factory */
    public String callProducerCreateSotwareFactoryEndPoint(CreateSoftwareFactoryRequestBody createSoftwareFactoryRequestBody){

        URI uri= UriComponentsBuilder.fromHttpUrl(host).
                path("/productor").
                build(true).
                toUri();
/*
        JsonObject requestBody= JsonBuilderFactory.buildObject()
                                                .add("name",name)
                                                .add("description",description)
                                                .getJson();*/

        //we are building the request
        RequestEntity<?> request= RequestEntity
                .post(uri)//set end point uri
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(createSoftwareFactoryRequestBody);//set request body

        //Obtain the response as a String in json format
        ResponseEntity<String> response= restTemplate.exchange(request, String.class);

        return response.getBody();
    }

}
