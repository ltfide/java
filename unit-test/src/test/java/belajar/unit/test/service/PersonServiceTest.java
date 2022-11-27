package belajar.unit.test.service;

import belajar.unit.test.data.Person;
import belajar.unit.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    public void setup() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambah behavior ke mock object
        Mockito.when(personRepository.selectById("lutfi"))
                .thenReturn(new Person("lutfi", "Lutfi"));

        var person = personService.get("lutfi");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("lutfi", person.getId());
        Assertions.assertEquals("Lutfi", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Lutfi");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Lutfi", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Lutfi"));
    }

}
