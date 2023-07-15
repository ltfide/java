package mapstruct.lib.mapper;

import org.mapstruct.Mapper;

import mapstruct.lib.dto.PersonDto;
import mapstruct.lib.model.Person;

@Mapper
public abstract class PersonMapper {

    public PersonDto personToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setFullname(person.getFirstname() + " " + person.getLastname());

        return personDto;
    }
}
