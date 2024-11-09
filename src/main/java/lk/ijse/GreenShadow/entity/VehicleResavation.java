package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle_resavation")
public class VehicleResavation {
    @Id
    private String resavationId;
    private String date;
    private String resone;
    private ResavationType resavationType;
    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = false)
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "vehicle_code",nullable = false)
    private Vehicle vehicle;
    private String license_plate_number;

}
