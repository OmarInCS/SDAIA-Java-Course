package org.example.mappers;

import org.example.dto.PaymentTypeDto;
import org.example.models.PaymentType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

@Mapper(componentModel = "cdi")
public interface PaymentTypeMapper {

//    @ValueMapping(source = "CARD_VISA", target = "CARD")
//    @ValueMapping(source = "CARD_MASTER", target = "CARD")
//    @ValueMapping(source = "CARD_CREDIT", target = "CARD")
    @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CARD")
//    @ValueMapping(source = "CASH", target = "CASH")
//    @ValueMapping(source = "CHEQUE", target = "CHEQUE")
//    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "CARD")
    PaymentTypeDto toDto(PaymentType p);


}
