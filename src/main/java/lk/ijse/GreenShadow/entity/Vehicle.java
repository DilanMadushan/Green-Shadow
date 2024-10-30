package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    private String vehicle_code;
    private String license_plate_number;
    private String vehicle_category;
    private String fuel_type;
    private String status;
    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = false)
    private Staff staff;
    private String remarks;
}
