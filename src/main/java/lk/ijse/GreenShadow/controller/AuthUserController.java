package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.Response.JWTAuthResponse;
import lk.ijse.GreenShadow.dto.SignInDTO;
import lk.ijse.GreenShadow.dto.UserDto;
import lk.ijse.GreenShadow.service.Impl.AuthonticationService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthonticationService authonticationService;
    @PostMapping("/signUp")
    public ResponseEntity<JWTAuthResponse> signUp(@RequestBody UserDto signUp){
        try {
            return ResponseEntity.ok(authonticationService.signUp(signUp));
        }catch (AlradyExsistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignInDTO signIn){
        return ResponseEntity.ok(authonticationService.signIn(signIn));
    }

    @PostMapping("/refresh/{token}")
    public ResponseEntity<JWTAuthResponse> refreshToken(@PathVariable("token") String token){
        return ResponseEntity.ok(authonticationService.refreshToken(token));
    }
}
