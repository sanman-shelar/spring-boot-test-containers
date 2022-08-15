package com.sb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class SpringBootTestContainersApplicationTests extends TestConfig {

    @Test
    @Order(1)
    void validatePersons() {
        var persons = testRestTemplate.getForEntity("/persons", PersonsReponse.class);
        assertEquals(persons.getBody().getContent().size(), 2);
        assertEquals(persons.getBody().getContent().get(0).name(), "Jake");
        assertEquals(persons.getBody().getContent().get(0).age(), 24);

        assertEquals(persons.getBody().getContent().get(1).name(), "Fred");
        assertEquals(persons.getBody().getContent().get(1).age(), 41);
    }

    @Test
    @Order(2)
    void createPersonTest() {
        var personResult = testRestTemplate.postForEntity("/persons", new PersonDTO("", "Sam", 23), PersonDTO.class);
        assertEquals(personResult.getStatusCodeValue(), 201);

        var result = testRestTemplate.getForEntity("/persons/".concat(personResult.getBody().id()), PersonDTO.class);

        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(result.getBody().id(), personResult.getBody().id());
        assertEquals(result.getBody().name(), "Sam");
        assertEquals(result.getBody().age(), 23);

    }

}
