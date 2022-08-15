package com.sb;

import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    PersonEntity dtoToEntity(PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personDTO.name());
        personEntity.setAge(personDTO.age());
        return personEntity;
    }

    PersonDTO entityToDto(PersonEntity personEntity) {
        PersonDTO personDTO = new PersonDTO(personEntity.getId().toString(), personEntity.getName(), personEntity.getAge());
        return personDTO;
    }
}
