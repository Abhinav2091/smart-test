package com.smart.test.mapper;

import com.smart.test.model.MockTest;
import com.smart.test.requestDTO.AddTestDTO;
import com.smart.test.responseDTO.MockTestDetailDTO;
import com.smart.test.responseDTO.MockTestResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {
    @Mapping(target = "currency", ignore = true)
    MockTest mapToMockTest(AddTestDTO addTestDTO);

    @Mapping(target = "currency", ignore = true)
    AddTestDTO mapToAddTestDTO(MockTest mockTest);

    @Mapping(target = "currency", ignore = true)
    List<MockTestResponseDTO> mapToMockTestResponseDTO(List<MockTest> mockTestList);

    @Mapping(target = "currency", ignore = true)
    MockTestDetailDTO mapToMockTestDetailDTO(MockTest mockTest);
}
