package lk.ijse.GreenShadow.dto;

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
    private String status;
    private String staffId;
    private String remarks;
}
