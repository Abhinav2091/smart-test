package com.smart.test.mapper;

import com.smart.test.model.MockTest;
import com.smart.test.requestDTO.AddTestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestMapper {
    MockTest mapToMockTest(AddTestDTO addTestDTO);

    AddTestDTO mapToAddTestDTO(MockTest mockTest);
}
