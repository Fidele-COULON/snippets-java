package fr.fidtec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import org.mapstruct.ReportingPolicy;

import fr.fidtec.beans.Car;
import fr.fidtec.beans.CarDTO;

// https://www.baeldung.com/mapstruct
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICarMapper {

    ICarMapper INSTANCE = Mappers.getMapper(ICarMapper.class);

    @Mapping(target = "seatCount", source = "numberOfSeats")
    @Mapping(target = "invariable",  constant = "BMW")
    CarDTO carToCarDto(Car car);
}
