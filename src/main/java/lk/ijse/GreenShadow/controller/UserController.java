package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.UserDto;
import lk.ijse.GreenShadow.service.UserService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("health")
    public String healthCheack(){
        return "All systems are running optimally";
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
        try {
            userService.saveUser(userDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (AlradyExsistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
