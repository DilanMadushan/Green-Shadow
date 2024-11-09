package lk.ijse.GreenShadow.dto;

import lk.ijse.GreenShadow.util.enums.ResavationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResavationDTO {
    private String resavationId;
    private String date;
    private String resone;
    private ResavationType type;
    private String staff_id;
    private String vehicle_code;
    private String license_plate_number;
}
