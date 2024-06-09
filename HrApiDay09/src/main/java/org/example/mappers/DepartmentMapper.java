package org.example.mappers;

import org.example.dto.DepartmentDto;
import org.example.models.Department;
import org.example.models.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(source = "departmentId", target = "deptId")
    @Mapping(source = "departmentName", target = "deptName")
    @Mapping(source = "locationId", target = "locId")
    DepartmentDto toDeptDto(Department d);

    @Mapping(source = "d.departmentId", target = "deptId")
    @Mapping(source = "d.departmentName", target = "deptName")
    @Mapping(source = "d.locationId", target = "locId")
    DepartmentDto toDeptDto(Department d, Location l);

    @Mapping(target = "departmentId", source = "deptId")
    @Mapping(target = "departmentName", source = "deptName")
    @Mapping(target = "locationId", source = "locId")
    Department toModel(DepartmentDto dto);

}
