package com.mappers.mappers.mapper;

import com.mappers.mappers.dto.GetProduct;
import com.mappers.mappers.entities.Product;
import org.mapstruct.*;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mappings({
            //al llamarse igual los Mapping las id del source y el target se pueden eliminar
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "creationDate",
                    target = "creationDate",
                    dateFormat = "yyyy-MM-dd HH-mm-ss")
    })
    GetProduct toGetDTO (Product product);

    @InheritInverseConfiguration
    Product toEntity(GetProduct getProduct);
}
