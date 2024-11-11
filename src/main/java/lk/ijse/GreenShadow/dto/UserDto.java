package lk.ijse.GreenShadow.dto;

import lk.ijse.GreenShadow.util.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String email;
    private String password;
    private Role role;
}
