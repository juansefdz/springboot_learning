package com.mappers.mappers.mapper;

import com.mappers.mappers.dto.GetProduct;
import com.mappers.mappers.entities.Product;
import org.mapstruct.*;

import java.util.List;
@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mappings({
            //al tener los identificadores iguales se pueden eliminar los mapping. no es necesario hacer el mapeo.
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "creationDate",
                    target = "creationDate",
                    dateFormat = "yyyy-MM-dd HH:mm:ss ")
    })
    GetProduct toGetDTO(Product product);

    // Método para convertir GetProduct (DTO) a Product (entidad)
    @InheritInverseConfiguration // Hereda la configuración inversa del método toGetDTO
    Product toEntity(GetProduct getProduct);

    // Método para convertir lista de Product a lista de GetProduct
    List<GetProduct> toGetProductList (List<Product> productList);
    // Método para convertir lista de GetProduct a lista de Product
    List<Product> toEntityList(List<GetProduct> getProductList);
}
