package com.sb;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonDTO save(PersonDTO person) {
        var personEntity = personMapper.dtoToEntity(person);
        var result = personRepository.save(personEntity);
        return personMapper.entityToDto(result);
    }

    public Page<PersonDTO> getAllPersons(Pageable pageable) {
        Page<PersonEntity> personEntities = personRepository.findAll(pageable);
        return new PageImpl<>(personEntities.getContent().stream().map(entity -> personMapper.entityToDto(entity)).toList(), pageable,
                personEntities.getTotalElements());
    }

    public PersonDTO getPersonById(UUID id) {
        var personEntity = personRepository.findById(id);
        return personMapper.entityToDto(personEntity.get());
    }

}
