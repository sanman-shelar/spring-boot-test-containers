package com.sb;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private final PersonService personService;
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PersonDTO savePerson(@RequestBody PersonDTO person) {
        return personService.save(person);
    }
    
    @GetMapping
    public Page<PersonDTO> getPersons(Pageable pageable) {
        return personService.getAllPersons(pageable);
    }
    
    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }
}
