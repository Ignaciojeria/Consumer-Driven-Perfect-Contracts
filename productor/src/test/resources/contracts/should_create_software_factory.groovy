org.springframework.cloud.contract.spec.Contract.make {
    name("should_create_software_company")
    description(
            """
            "given: a request to create an software factory"
            
            "when:  the software factory is stored in database"
            
            "then:  the created software factory is returned"
    """)
    request {
        method 'POST'
        url '/producer'
        body(
                name: $(c(regex(nonBlank()))),
                description: $(c(regex(nonBlank())))
        )
        headers {
          contentType(applicationJson())
        }
    }
    response {
        status 201
        body(   name: $(p(fromRequest().body('name'))),
                description: $(p(fromRequest().body('description'))))
        headers {
            contentType(applicationJson())
        }
    }
}