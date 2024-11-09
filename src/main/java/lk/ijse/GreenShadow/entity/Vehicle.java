package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.util.enums.Status;
import lombok.*;

import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private Status status;
    private String remarks;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleResavation> vehicleResavations;
}
