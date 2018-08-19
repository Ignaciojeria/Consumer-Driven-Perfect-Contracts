package com.productor.resource;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductorResource {

    /**
     *El consumidor define una necesidad de negocio y el productor es el encargado de cumplir esa necesidad de
     * negocio en el contrato expuesto
     */
    @PostMapping("/producer")
    public String responseTest(@RequestBody String consumerRequest){
        return consumerRequest;
    }
}
