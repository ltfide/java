package mapstruct.lib;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import mapstruct.lib.dto.PersonDto;
import mapstruct.lib.mapper.PersonMapper;
import mapstruct.lib.model.Person;

public class PersonMapperTest {

    PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

    @Test
    void test() {
        Person person = new Person();
        person.setFirstname("Lutfi");
        person.setLastname("Dendiansyah");

        PersonDto personDto = personMapper.personToPersonDto(person);
        System.out.println(personDto.getFullname());
    }
}
