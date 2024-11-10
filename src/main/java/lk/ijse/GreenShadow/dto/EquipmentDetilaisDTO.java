package lk.ijse.GreenShadow.dto;


import lk.ijse.GreenShadow.util.enums.ResavationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDetilaisDTO {
    private String detailId;
    private String date;
    private String resone;
    private ResavationType resavationType;
    private String staff_id;
    private String field_code;
    private String equipment_Id;
}
