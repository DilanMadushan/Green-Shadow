package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.UserDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;
import lk.ijse.GreenShadow.entity.User;
import lk.ijse.GreenShadow.repository.UserRepo;
import lk.ijse.GreenShadow.service.UserService;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveUser(UserDto userDto) {
        if (userRepo.existsById(userDto.getEmail())) throw new AlradyExsistException("user Alrady Exsist");
        userRepo.save(map.toUserEntity(userDto));
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(UserDto userDto) {
        User found = userRepo.findById(userDto.getEmail()).orElseThrow(() -> new NotFoundException("User not Found"));
        User update = map.toUserEntity(userDto);
        convater.convertUser(found,update);
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
