package lk.ijse.GreenShadow.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lk.ijse.GreenShadow.entity.MonitoringLog;
import lk.ijse.GreenShadow.entity.Vehicle;
import lk.ijse.GreenShadow.util.enums.Designation;
import lk.ijse.GreenShadow.util.enums.Gender;
import lk.ijse.GreenShadow.util.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDto {
    private String staff_id;
    private String first_name;
    private String last_name;
    private Designation designation;
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String address_line_1;
    private String address_line_2;
    private String address_line_3;
    private String address_line_4;
    private String address_line_5;
    private String tel;
    private String email;
    private Role role;
    private List<MonitoringLog> log;
    private List<lk.ijse.GreenShadow.entity.Vehicle> Vehicle;
}
