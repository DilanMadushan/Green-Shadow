package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.Response.JWTAuthResponse;
import lk.ijse.GreenShadow.dto.SignInDTO;
import lk.ijse.GreenShadow.dto.UserDto;
import lk.ijse.GreenShadow.entity.User;
import lk.ijse.GreenShadow.repository.UserRepo;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthonticationService {
    private final UserRepo userRepo;
    private final Map map;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;;
    public JWTAuthResponse signUp(UserDto signUp) {
        signUp.setPassword(passwordEncoder.encode(signUp.getPassword()));
        User user = map.toUserEntity(signUp);
        if (userRepo.existsById(signUp.getEmail())) throw new AlradyExsistException("user Alrady Exsist");
        userRepo.save(user);
        var jwtToken = jwtService.genarateToken(user);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public JWTAuthResponse signIn(SignInDTO signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signIn.getEmail(),
                        signIn.getPassword()
                )
        );
        User user = userRepo.findByEmail(signIn.getEmail()).orElseThrow(() -> new NotFoundException("User not Found"));
        var jwtToken = jwtService.genarateToken(user);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public JWTAuthResponse refreshToken(String token) {
        String email = jwtService.extractUserName(token);
        User user = userRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("User not Found"));
        var jwtToken = jwtService.genarateToken(user);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
