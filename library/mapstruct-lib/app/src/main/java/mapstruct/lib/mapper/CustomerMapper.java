package mapstruct.lib.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import mapstruct.lib.dto.CustomerDto;
import mapstruct.lib.model.Customer;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = ".", source = "account")
    Customer customerDtoToCustomer(CustomerDto customerDto);

    void updateCustomerFromDto(CustomerDto customerDto, @MappingTarget Customer customer);
}
