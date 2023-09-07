package com.smart.test.mapper;

import com.smart.test.model.Category;
import com.smart.test.responseDTO.CategoryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source ="cLevel" ,target ="level" )
    @Mapping(source ="cname" ,target ="value" )
    List<CategoryResponseDTO> mapToCategoryResponseDTO(List<Category> categories);
}
