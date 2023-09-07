package com.smart.test.mapper;

import com.smart.test.model.User;
import com.smart.test.requestDTO.AddUserDto;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface UserMapper {

    AddUserDto mapToAddUserDto(User user);

    User mapToUser(AddUserDto addUserDto);

}
