package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.UserDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterUserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    void deleteUser(String id);
    void updateUser(UserDto userDto);
    List<UserDto> getAllUser(FilterUserDto filterUserDto);
    String findLatIndex();
}
