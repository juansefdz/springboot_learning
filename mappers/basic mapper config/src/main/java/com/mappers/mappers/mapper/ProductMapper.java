package com.mappers.mappers.mapper;

import com.mappers.mappers.dto.GetProduct;
import com.mappers.mappers.entities.Product;
import org.mapstruct.*;

import java.util.List;
@Mapper (componentModel = MappingConstants.ComponentModel.SPRING) // Define que esta interfaz es un Mapper de MapStruct y especifica que se integrará con el contenedor de Spring.
public interface ProductMapper {

    @Mappings({ // Define un grupo de mapeos entre propiedades de objetos.
            //al llamarse igual los Mapping las id del source y el target se pueden eliminar
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "creationDate",
                    target = "creationDate",
                    dateFormat = "yyyy-MM-dd HH-mm-ss") // Especifica el formato de fecha para el campo 'creationDate' en el objeto destino.
    })
    GetProduct toGetDTO (Product product); // Método que convierte un objeto 'Product' en un objeto 'GetProduct'.

    @InheritInverseConfiguration // Indica que este método debe invertir el mapeo definido en 'toGetDTO'.
    Product toEntity(GetProduct getProduct); // Método que convierte un objeto 'GetProduct' en un objeto 'Product'.

    List<GetProduct> toGetProductList (List<Product> productList); // Método que convierte una lista de 'Product' en una lista de 'GetProduct'.
    List<Product> toEntityList(List<GetProduct> getProductList); // Método que convierte una lista de 'GetProduct' en una lista de 'Product'.
}
