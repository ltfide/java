package mapstruct.lib.mapper;

import javax.annotation.processing.Generated;
import mapstruct.lib.dto.DeliveryAddressDto;
import mapstruct.lib.model.Address;
import mapstruct.lib.model.Person;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-15T20:43:44+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230622-1425, environment: Java 17 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, Address address, String street) {
        if ( person == null && address == null && street == null ) {
            return null;
        }

        DeliveryAddressDto deliveryAddressDto = new DeliveryAddressDto();

        if ( person != null ) {
            deliveryAddressDto.setDescription( person.getDescription() );
        }
        if ( address != null ) {
            deliveryAddressDto.setHouseNumber( address.getHouseNo() );
        }
        deliveryAddressDto.setStreet( street );

        return deliveryAddressDto;
    }
}
