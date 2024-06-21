package com.mappers.mappers.mapper;

import com.mappers.mappers.dto.GetProduct;
import com.mappers.mappers.entities.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-20T18:04:16-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_1961003712 = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH-mm-ss" );

    @Override
    public GetProduct toGetDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        GetProduct getProduct = new GetProduct();

        getProduct.setId( product.getId() );
        getProduct.setName( product.getName() );
        if ( product.getCreationDate() != null ) {
            getProduct.setCreationDate( dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_1961003712.format( product.getCreationDate() ) );
        }

        return getProduct;
    }

    @Override
    public Product toEntity(GetProduct getProduct) {
        if ( getProduct == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( getProduct.getId() );
        product.setName( getProduct.getName() );
        if ( getProduct.getCreationDate() != null ) {
            product.setCreationDate( LocalDateTime.parse( getProduct.getCreationDate(), dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_1961003712 ) );
        }

        return product;
    }

    @Override
    public List<GetProduct> toGetProductList(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<GetProduct> list = new ArrayList<GetProduct>( productList.size() );
        for ( Product product : productList ) {
            list.add( toGetDTO( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toEntityList(List<GetProduct> getProductList) {
        if ( getProductList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( getProductList.size() );
        for ( GetProduct getProduct : getProductList ) {
            list.add( toEntity( getProduct ) );
        }

        return list;
    }
}
