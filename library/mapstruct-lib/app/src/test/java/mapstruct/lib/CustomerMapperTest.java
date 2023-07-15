package mapstruct.lib;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import mapstruct.lib.dto.CustomerDto;
import mapstruct.lib.mapper.CustomerMapper;
import mapstruct.lib.model.Account;
import mapstruct.lib.model.Customer;

public class CustomerMapperTest {

    CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Test
    void test() {
        Account account = new Account();
        account.setAccountNumber("1111");

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Lutfi");
        customerDto.setAccount(account);

        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        System.out.println(customer.getName()); // Lutfi
        System.out.println(customer.getAccount().getAccountNumber()); // 111
    }
}
