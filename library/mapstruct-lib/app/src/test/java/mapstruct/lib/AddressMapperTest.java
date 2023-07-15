package mapstruct.lib;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import mapstruct.lib.dto.DeliveryAddressDto;
import mapstruct.lib.mapper.AddressMapper;
import mapstruct.lib.model.Address;
import mapstruct.lib.model.Person;

public class AddressMapperTest {

    AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    @Test
    void test() {
        Person person = new Person();
        person.setDescription("description 1");

        Address address = new Address();
        address.setHouseNo(10);

        String street = "Jl. Sudirman";

        DeliveryAddressDto addressDto = addressMapper.personAndAddressToDeliveryAddressDto(person, address,
                street);
        System.out.println(addressDto.getDescription()); // description 1
        System.out.println(addressDto.getHouseNumber()); // 10
        System.out.println(addressDto.getStreet()); // Jl. Sudirman
    }
}
