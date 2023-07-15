package mapstruct.lib.mapper;

import javax.annotation.processing.Generated;
import mapstruct.lib.dto.CarDto;
import mapstruct.lib.model.Car;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-15T20:09:44+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230622-1425, environment: Java 17 (Oracle Corporation)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setSeatCount( String.valueOf( car.getNumberOfSeat() ) );
        carDto.setName( car.getName() );

        carDto.setB( car.getA().toLowerCase() );

        return carDto;
    }
}
