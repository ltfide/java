package mapstruct.lib.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mapstruct.lib.dto.CarDto;
import mapstruct.lib.model.Car;

@Mapper
public interface CarMapper {

    @Mapping(source = "numberOfSeat", target = "seatCount")
    @Mapping(expression = "java(car.getA().toLowerCase())", target = "b")
    CarDto carToCarDto(Car car);
}
