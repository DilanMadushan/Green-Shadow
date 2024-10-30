package lk.ijse.GreenShadow.dto;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.entity.MonitoringLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO {
    @Id
    private String crop_code;
    private String common_name;
    private String scientific_name;
    private String crop_image;
    private String category;
    private String crop_season;
    private String field_code;
    private List<MonitoringLog> logs;
}
