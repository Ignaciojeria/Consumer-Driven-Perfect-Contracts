package com.consumidor.service;
import com.consumidor.repository.adapter.ProducerRestAdapter;
import com.consumidor.request.CreateSoftwareFactoryRequestBody;
import com.consumidor.service.builder.SoftwareFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerRestAdapterService {

    @Autowired
    private ProducerRestAdapter producerRestAdapter;

    public SoftwareFactoryBuilder createSoftwareFactory(CreateSoftwareFactoryRequestBody requestBody){
        /**
         * could create a pre-conditions for call microservice end point
         */
        //.. condition A
        //.. condition B

        //call microservice endpoint
        String response= producerRestAdapter.callProducerCreateSotwareFactoryEndPoint(requestBody);


        return null;
    }

    public String inyectaDependencia(){
        return "Dependencia inyectada y método probado de forma satisfactoria!";
    }


}
