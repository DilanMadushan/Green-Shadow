package lk.ijse.GreenShadow.dto;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.entity.Field;
import lk.ijse.GreenShadow.entity.Staff;
import lk.ijse.GreenShadow.util.enums.EquipmentStatus;
import lk.ijse.GreenShadow.util.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO {
    private String equipment_Id;
    private String name;
    private EquipmentType type;
    private EquipmentStatus status;
    private String staff_id;
    private String field_code;
}
