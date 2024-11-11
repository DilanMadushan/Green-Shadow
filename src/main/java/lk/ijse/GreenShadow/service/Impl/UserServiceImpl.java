package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.Specification.StaffSpecification;
import lk.ijse.GreenShadow.Specification.UserSpecification;
import lk.ijse.GreenShadow.dto.UserDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterUserDto;
import lk.ijse.GreenShadow.entity.Staff;
import lk.ijse.GreenShadow.entity.User;
import lk.ijse.GreenShadow.repository.UserRepo;
import lk.ijse.GreenShadow.service.UserService;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not Found"));
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(UserDto userDto) {
        User found = userRepo.findById(userDto.getEmail()).orElseThrow(() -> new NotFoundException("User not Found"));
        User update = map.toUserEntity(userDto);
        convater.convertUser(found,update);
    }

    @Override
    public List<UserDto> getAllUser(FilterUserDto filterUserDto) {
        Pageable pageable = PageRequest.of(filterUserDto.getPage(), filterUserDto.getPerPage());
        Specification<User> specification = UserSpecification.createSpecification(filterUserDto);

        Page<User> all = userRepo.findAll(specification, pageable);
        List<UserDto> users = new ArrayList<>();

        if(all !=null){
            for (User user : all) {
                users.add(map.toUserDto(user));
            }
            return users;
        }else new NotFoundException("Users not Found");

        return null;
    }

    @Override
    public String findLatIndex() {
        return null;
    }
}
