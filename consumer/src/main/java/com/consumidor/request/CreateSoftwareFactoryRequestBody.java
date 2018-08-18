package com.consumidor.request;

public class CreateSoftwareFactoryRequestBody {
    /**
     * No crear composiciones ni reutilizar las requestBody. Procura crear una por cada POST
     * que reciba un determinado cuerpo por el hecho de que están demaciado acopladas con los
     * service, repository y resource
     */
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
