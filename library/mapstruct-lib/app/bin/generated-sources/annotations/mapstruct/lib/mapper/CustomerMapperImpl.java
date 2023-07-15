package mapstruct.lib.mapper;

import javax.annotation.processing.Generated;
import mapstruct.lib.dto.CustomerDto;
import mapstruct.lib.model.Customer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-15T22:15:35+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230622-1425, environment: Java 17 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerDto.getName() );
        customer.setAccount( customerDto.getAccount() );

        return customer;
    }

    @Override
    public void updateCustomerFromDto(CustomerDto customerDto, Customer customer) {
        if ( customerDto == null ) {
            return;
        }

        customer.setAccount( customerDto.getAccount() );
        customer.setName( customerDto.getName() );
    }
}
