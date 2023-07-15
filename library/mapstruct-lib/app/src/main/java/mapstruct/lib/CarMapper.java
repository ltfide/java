package mapstruct.lib;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CarMapper {

    @Mapping(source = "numberOfSeat", target = "seatCount")
    @Mapping(expression = "java(car.getA().toLowerCase())", target = "b")
    CarDto carToCarDto(Car car);
}
