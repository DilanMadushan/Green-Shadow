package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.UserDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;
import lk.ijse.GreenShadow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(UserDto userDto) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(UserDto userDto) {

    }

    @Override
    public List<UserDto> getAllUser(FilterFieldDTO filterFieldDTO) {
        return null;
    }

    @Override
    public String findLatIndex() {
        return null;
    }
}
