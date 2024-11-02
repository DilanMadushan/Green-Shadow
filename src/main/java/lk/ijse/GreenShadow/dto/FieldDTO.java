package lk.ijse.GreenShadow.dto;


import lk.ijse.GreenShadow.entity.Crop;
import lk.ijse.GreenShadow.entity.MonitoringLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO {
    private String field_code;
    private String field_Name;
    private String field_location;
    private double extent_size_of_field;
    private List<Crop> crops;
    private List<MonitoringLog> log;
    private String field_image_1;
    private String field_image_2;
}
