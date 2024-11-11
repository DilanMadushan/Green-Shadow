package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MONITERINGLOG")
public class MonitoringLog {
    @Id
    @Column(name = "log_code")
    private String log_code;
    private Date log_date;
    private String log_details;
    @Column(columnDefinition = "LONGTEXT")
    private String observed_image;
    @ManyToOne
    @JoinColumn(name = "field_code",nullable = false)
    private Field field;
    @ManyToOne
    @JoinColumn(name = "crop_code",nullable = false)
    private Crop crop;
    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = false)
    private Staff staff;
}
