package mapstruct.lib;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import mapstruct.lib.dto.CarDto;
import mapstruct.lib.mapper.CarMapper;
import mapstruct.lib.model.Car;

public class CarMapperTest {

    CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    @Test
    void test() {
        Car car = new Car();
        car.setName("A");
        car.setNumberOfSeat(10);
        car.setA("B");

        CarDto carToCarDto = carMapper.carToCarDto(car);
        System.out.println(carToCarDto.getName());
        System.out.println(carToCarDto.getSeatCount());
        System.out.println(carToCarDto.getB());
    }
}
