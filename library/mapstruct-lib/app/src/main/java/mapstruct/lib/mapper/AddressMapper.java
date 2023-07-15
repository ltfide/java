package mapstruct.lib.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mapstruct.lib.dto.DeliveryAddressDto;
import mapstruct.lib.model.Address;
import mapstruct.lib.model.Person;

@Mapper
public interface AddressMapper {

    @Mapping(target = "description", source = "person.description")
    @Mapping(target = "houseNumber", source = "address.houseNo")
    @Mapping(target = "street", source = "street")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, Address address, String street);
}
