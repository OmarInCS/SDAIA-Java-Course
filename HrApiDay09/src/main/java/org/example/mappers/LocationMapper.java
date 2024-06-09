package org.example.mappers;

import org.example.dto.DepartmentDto;
import org.example.dto.LocationDto;
import org.example.models.Location;
import org.mapstruct.Mapper;

@Mapper
public interface LocationMapper {

    LocationDto toLocDto(Location l);

    Location toModel(LocationDto dto);
}
