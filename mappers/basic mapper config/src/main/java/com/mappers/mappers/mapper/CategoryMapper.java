package com.mappers.mappers.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.mappers.mappers.dto.GetCategory;
import com.mappers.mappers.entities.Category;


@Mapper(componentModel=MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    GetCategory toGetCategory(Category category);

    @InheritInverseConfiguration
    Category toEntity(GetCategory getCategory);

    List<GetCategory> toGetCategoryList(List<Category>categoryList);

    List<Category> toEntityList(List<GetCategory> getCategoryList);


    

    
}
