package mapstruct.lib;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CarMapper {

    @Mapping(source = "numberOfSeat", target = "seatCount")
    @Mapping(source = "a", target = "b")
    CarDto carToCarDto(Car car);
}
