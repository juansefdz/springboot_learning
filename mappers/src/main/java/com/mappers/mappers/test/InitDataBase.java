package com.mappers.mappers.test;

import com.mappers.mappers.dto.GetProduct;
import com.mappers.mappers.entities.Product;
import com.mappers.mappers.mapper.ProductMapper;
import com.mappers.mappers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class InitDataBase {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Bean
    public CommandLineRunner testProductMapperCommand(){
        return args -> {
            List<Product> products = productRepository.findAll();
            System.out.println("PRODUCTS");
            /* primera manera
            products.forEach(product -> System.out.println(product));
            */
            //segunda manera mejor
            products.forEach(System.out::println);

            System.out.println("GET PRODUCTS");
            List<GetProduct>getProductList = products
                    .stream().map(product -> productMapper.toGetDTO(product))
                    .peek(System.out::println) //hace lo mismo que el foreach pero con un return del getproduct
                    .collect(Collectors.toList());
        };
    }
}
