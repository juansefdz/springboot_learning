package com.mappers.mappers.dto;

import com.mappers.mappers.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCategory {

    private long id;
    private String name;  
    
}
