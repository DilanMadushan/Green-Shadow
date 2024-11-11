package lk.ijse.GreenShadow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogDTO {
    private String log_code;
    private Date log_date;
    private String log_details;
    private String observed_image;
    private String field_code;
    private String crop_code;
    private String staff_id;
}
