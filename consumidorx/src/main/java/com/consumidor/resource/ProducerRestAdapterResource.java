package com.consumidor.resource;
import com.consumidor.request.CreateSoftwareFactoryRequestBody;
import com.consumidor.service.ProducerRestAdapterService;
import com.consumidor.service.builder.SoftwareFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class ProducerRestAdapterResource {

    @Autowired
    private ProducerRestAdapterService producerRestAdapterService;

    @PostMapping(value="/consumer" )
    public SoftwareFactoryBuilder createSoftwareFactory(@RequestBody CreateSoftwareFactoryRequestBody requestBody){
        return producerRestAdapterService.createSoftwareFactory(requestBody);
    }

}
