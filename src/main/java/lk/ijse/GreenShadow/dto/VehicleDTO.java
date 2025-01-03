package lk.ijse.GreenShadow.dto;

import lk.ijse.GreenShadow.util.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String vehicle_code;
    private String license_plate_number;
    private String vehicle_category;
    private String fuel_type;
    private Status status;
    private String remarks;
}
