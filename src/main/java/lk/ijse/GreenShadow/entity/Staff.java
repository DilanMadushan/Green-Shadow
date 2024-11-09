package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.util.enums.Designation;
import lk.ijse.GreenShadow.util.enums.Gender;
import lk.ijse.GreenShadow.util.enums.Role;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "STAFF")
public class Staff {
    @Id
    private String staff_id;
    private String first_name;
    private String last_name;
    @Enumerated(EnumType.STRING)
    private Designation designation;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String address_line_1;
    private String address_line_2;
    private String address_line_3;
    private String address_line_4;
    private String address_line_5;
    private String tel;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "staff")
    private List<MonitoringLog> log;
    @OneToMany(mappedBy = "staff")
    private List<VehicleResavation> vehicleResavations;
}
